package com.enjoy.service.user;

import com.enjoy.NextFilmApplication;
import com.enjoy.controller.user.EnrollUserVO;
import com.enjoy.controller.user.UserInfoVO;
import com.enjoy.service.common.exception.CommonServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {NextFilmApplication.class})
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void userEnroll() throws CommonServiceException {
        EnrollUserVO enrollUserVO = new EnrollUserVO(){{
            setUsername("1");
            setPassword("1");
            setEmail("1");
            setPhone("1");
            setAddress("1");
        }};
        userService.userEnroll(enrollUserVO);
    }

    @Test
    public void checkUserName() throws CommonServiceException {
        boolean hasUserName = userService.checkUserName("1");
        System.out.println("hasUserName=" + hasUserName);
    }

    @Test
    public void userAuth() throws CommonServiceException {
        boolean authResult = userService.userAuth("1","1");
        System.out.println("authResult=" + authResult);
    }

    @Test
    public void describeUserInfo() throws CommonServiceException {
        UserInfoVO userInfoVO = userService.describeUserInfo("3");
        System.out.println(userInfoVO);
    }

    @Test
    public void updateUserInfo() {
    }
}
