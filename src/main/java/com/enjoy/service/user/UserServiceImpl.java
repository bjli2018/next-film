package com.enjoy.service.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.enjoy.common.utils.MD5Util;
import com.enjoy.common.utils.ToolUtils;
import com.enjoy.controller.user.EnrollUserVO;
import com.enjoy.controller.user.UserInfoVO;
import com.enjoy.dao.entity.NextUserT;
import com.enjoy.dao.mapper.NextUserTMapper;
import com.enjoy.service.common.exception.CommonServiceException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private NextUserTMapper nextUserTMapper;

    @Override
    public void userEnroll(EnrollUserVO enrollUserVO) throws CommonServiceException {
        //EnrollUserVO->NextUserT转换
        NextUserT nextUserT = new NextUserT(){{
            setUserName(enrollUserVO.getUsername());
            setUserPwd(MD5Util.encrypt(enrollUserVO.getPassword()));
        }};
        BeanUtils.copyProperties(enrollUserVO,nextUserT);

        //数据插入
        int isSuccess = nextUserTMapper.insert(nextUserT);

        //判断数据是否插入成功
        if(isSuccess!=1){
            throw new CommonServiceException(501,"用户登记失败!");
        }
    }

    @Override
    public boolean checkUserName(String userName) throws CommonServiceException {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name",userName);

        Integer hasUserName = nextUserTMapper.selectCount(queryWrapper);

        return hasUserName==0?false:true;
    }

    @Override
    public boolean userAuth(String userName, String userPwd) throws CommonServiceException {
        if(ToolUtils.isEmpty(userName)||ToolUtils.isEmpty(userPwd)){
            throw new CommonServiceException(400,"用户登录失败!");
        }

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name",userName);

        //1.判断用户是否存在
        List<NextUserT> list = nextUserTMapper.selectList(queryWrapper);
        if(list.size()==0){
            return false;
        } else {
            NextUserT nextUserT = list.get(0);
            if (MD5Util.encrypt(userPwd).equals(nextUserT.getUserPwd())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public UserInfoVO describeUserInfo(String userId) throws CommonServiceException {
        NextUserT nextUserT = nextUserTMapper.selectById(userId);
        if(nextUserT!=null && nextUserT.getUuid()!=null){
            UserInfoVO userInfoVO = user2InfoVO(nextUserT);
            return userInfoVO;
        } else {
            throw new CommonServiceException(404,"用户编号["+userId+"]的用户不存在");
        }
    }

    @Override
    public UserInfoVO updateUserInfo(UserInfoVO userInfoVO) throws CommonServiceException {
        NextUserT nextUserT = info2User(userInfoVO);
        if(userInfoVO!=null && userInfoVO.getUuid()!=null){
            int isSuccess = nextUserTMapper.updateById(nextUserT);
            if(isSuccess>0){
                return userInfoVO;
            }else{
                throw new CommonServiceException(500,"用户信息修改失败");
            }
        } else {
            throw new CommonServiceException(404,"用户编号["+userInfoVO.getUuid()+"]的用户不存在");
        }
    }

    /**
     * ---------------------------------------以下是自定义方法----------------------------------------------
     */
    private UserInfoVO user2InfoVO(NextUserT nextUserT){
        UserInfoVO userInfoVO = new UserInfoVO(){{
            setUsername(nextUserT.getUserName());
            setNickname(nextUserT.getNickName());
            setBeginTime(nextUserT.getBeginTime().toEpochSecond(ZoneOffset.of("+8")));
            setUpdateTime(nextUserT.getUpdateTime().toEpochSecond(ZoneOffset.MAX));
            setLifeState(String.valueOf(nextUserT.getLifeState()));
        }};
        BeanUtils.copyProperties(nextUserT,userInfoVO);
        return userInfoVO;
    }

    private NextUserT info2User(UserInfoVO userInfoVO){
        NextUserT nextUserT = new NextUserT(){{
            setUserName(userInfoVO.getUsername());
            setNickName(userInfoVO.getNickname());
            setUpdateTime(LocalDateTime.now());
            if(Optional.ofNullable(userInfoVO.getLifeState()).isPresent()){
                setLifeState(Integer.parseInt(userInfoVO.getLifeState()));
            }
        }};
        BeanUtils.copyProperties(userInfoVO,nextUserT);
        return nextUserT;
    }
}
