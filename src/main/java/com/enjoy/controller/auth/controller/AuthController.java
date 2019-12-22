package com.enjoy.controller.auth.controller;

import com.enjoy.controller.auth.controller.util.JwtTokenUtil;
import com.enjoy.controller.auth.controller.vo.AuthRequestVO;
import com.enjoy.controller.auth.controller.vo.AuthResponseVO;
import com.enjoy.controller.common.BaseResponseVO;
import com.enjoy.controller.exception.NextFilmException;
import com.enjoy.controller.exception.ParamErrorException;
import com.enjoy.controller.user.UserInfoVO;
import com.enjoy.service.common.exception.CommonServiceException;
import com.enjoy.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by BJLI on 2019/12/22.
 */
@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("auth")
    public BaseResponseVO auth(@RequestBody AuthRequestVO authRequestVO) throws CommonServiceException, ParamErrorException, NextFilmException {
        authRequestVO.checkParam();

        boolean isValid = userService.userAuth(authRequestVO.getUsername(),authRequestVO.getPassword());

        if(isValid){
            String randomKey = jwtTokenUtil.getRandomKey();
            String token = jwtTokenUtil.generateToken(authRequestVO.getUsername(),randomKey);

            AuthResponseVO authResponseVO = AuthResponseVO.
                    builder().randomKey(randomKey).token(token).build();
            return BaseResponseVO.success(authResponseVO);
        }
        return BaseResponseVO.serviceFailed("用户名或密码不正确");
    }
}
