package com.enjoy.controller.user;

import com.enjoy.common.utils.ToolUtils;
import com.enjoy.controller.common.BaseVO;
import com.enjoy.controller.exception.ParamErrorException;
import lombok.Data;

import java.io.Serializable;

@Data
public class EnrollUserVO extends BaseVO implements Serializable {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;


    @Override
    public void checkParam() throws ParamErrorException {
        if(ToolUtils.isEmpty(this.getUsername())){
            throw new ParamErrorException(400,"用户名不能为空");
        }
        if(ToolUtils.isEmpty(this.getPassword())){
            throw new ParamErrorException(400,"密码不能为空");
        }
    }
}
