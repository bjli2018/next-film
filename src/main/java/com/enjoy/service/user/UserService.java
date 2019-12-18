package com.enjoy.service.user;

import com.enjoy.controller.user.EnrollUserVO;
import com.enjoy.controller.user.UserInfoVO;
import com.enjoy.service.common.exception.CommonServiceException;

public interface UserService {
    /**
     * 用户注册接口
     * @param enrollUserVO
     * @throws CommonServiceException
     */
    void userEnroll(EnrollUserVO enrollUserVO) throws CommonServiceException;

    /**
     * 验证用户名是否存在
     * @param userName
     * @return
     * @throws CommonServiceException
     */
    boolean checkUserName(String userName) throws CommonServiceException;

    /**
     * 用户名密码验证
     * @param userName
     * @param userPwd
     * @return
     * @throws CommonServiceException
     */
    boolean userAuth(String userName,String userPwd) throws CommonServiceException;

    /**
     * 获取用户信息
     * @param userId
     * @return
     * @throws CommonServiceException
     */
    UserInfoVO describeUserInfo(String userId) throws CommonServiceException;

    /**
     * 修改用户信息
     * @param userInfoVO
     * @return
     * @throws CommonServiceException
     */
    UserInfoVO updateUserInfo(UserInfoVO userInfoVO) throws CommonServiceException;
}
