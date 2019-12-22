package com.enjoy.controller.auth.controller.vo;

import com.enjoy.controller.common.BaseVO;
import com.enjoy.controller.exception.ParamErrorException;
import lombok.Data;

/**
 * Created by BJLI on 2019/12/22.
 */
@Data
public class AuthRequestVO extends BaseVO {
    private String username;
    private String password;

    @Override
    public void checkParam() throws ParamErrorException {

    }
}
