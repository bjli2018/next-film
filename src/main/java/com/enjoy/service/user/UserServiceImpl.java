package com.enjoy.service.user;

import com.enjoy.controller.user.EnrollUserVO;
import com.enjoy.controller.user.UserInfoVO;
import com.enjoy.dao.mapper.NextUserTMapper;
import com.enjoy.service.common.exception.CommonServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private NextUserTMapper nextUserTMapper;

    @Override
    public void userEnroll(EnrollUserVO enrollUserVO) throws CommonServiceException {

    }

    @Override
    public boolean checkUserName(String userName) throws CommonServiceException {
        return false;
    }

    @Override
    public boolean userAuth(String userName, String userPwd) throws CommonServiceException {
        return false;
    }

    @Override
    public UserInfoVO describeUserInfo(String userId) throws CommonServiceException {
        return null;
    }

    @Override
    public UserInfoVO updateUserInfo(UserInfoVO userInfoVO) throws CommonServiceException {
        return null;
    }
}
