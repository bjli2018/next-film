package com.enjoy.controller.user;

import com.enjoy.common.utils.ToolUtils;
import com.enjoy.controller.common.BaseResponseVO;
import com.enjoy.controller.common.TraceUtil;
import com.enjoy.controller.exception.NextFilmException;
import com.enjoy.controller.exception.ParamErrorException;
import com.enjoy.service.common.exception.CommonServiceException;
import com.enjoy.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户名验证接口
 * Created by BJLI on 2019/12/21.
 */
@RestController
@RequestMapping("/nextfilm/user/")
@Api("用户模块相关的API")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户名重复性验证",notes = "用户名重复性验证")
    @ApiImplicitParam(name="username", value="待验证的用户名",paramType = "query", required=true, dataType="String")
    @PostMapping("check")
    public BaseResponseVO checkUser(String username) throws CommonServiceException,NextFilmException{
        if(ToolUtils.isEmpty(username)){
            throw new NextFilmException(1,"username不能为空");
        }

        boolean hasUserName = userService.checkUserName(username);
        if(hasUserName){
            return BaseResponseVO.serviceFailed("用户名已存在");
        }
        return BaseResponseVO.success();
    }

    @PostMapping("register")
    public BaseResponseVO register(@RequestBody EnrollUserVO enrollUserVO) throws CommonServiceException, ParamErrorException {

        enrollUserVO.checkParam();

        userService.userEnroll(enrollUserVO);

        return BaseResponseVO.success();
    }

    @GetMapping("getUserInfo")
    public BaseResponseVO describeUserInfo() throws CommonServiceException, ParamErrorException {

        String userId = TraceUtil.getUserId();

        UserInfoVO userInfoVO = userService.describeUserInfo(userId);

        userInfoVO.checkParam();

        return BaseResponseVO.success(userInfoVO);
    }

    @PostMapping("updateUserInfo")
    public BaseResponseVO updateUserInfo(@RequestBody UserInfoVO userInfoVO) throws CommonServiceException, ParamErrorException {
        userInfoVO.checkParam();

        UserInfoVO result = userService.updateUserInfo(userInfoVO);

        userInfoVO.checkParam();

        return BaseResponseVO.success(result);
    }

    @PostMapping("logout")
    public BaseResponseVO logout() throws CommonServiceException, ParamErrorException {

        String userId = TraceUtil.getUserId();

        //TODO
        /*
            1.用户信息放入redis缓存
            2.去掉用户缓存
         */

        return BaseResponseVO.success();
    }
}
