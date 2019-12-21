package com.enjoy.controller.user;

import com.enjoy.common.utils.ToolUtils;
import com.enjoy.controller.common.BaseResponseVO;
import com.enjoy.controller.exception.NextFilmException;
import com.enjoy.service.common.exception.CommonServiceException;
import com.enjoy.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 用户名验证接口
 * Created by BJLI on 2019/12/21.
 */
@RestController
@RequestMapping("/nextfilm/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("check")
    public Object checkUser(String username) throws CommonServiceException,NextFilmException{
        if(ToolUtils.isEmpty(username)){
            throw new NextFilmException(1,"username不能为空");
        }

        boolean hasUserName = userService.checkUserName(username);
        if(hasUserName){
            return BaseResponseVO.serviceFailed("用户名已存在");
        }
        return BaseResponseVO.success();
    }
}
