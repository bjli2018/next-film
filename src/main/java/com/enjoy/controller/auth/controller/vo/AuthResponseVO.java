package com.enjoy.controller.auth.controller.vo;

import com.enjoy.controller.common.BaseVO;
import com.enjoy.controller.exception.ParamErrorException;
import lombok.Builder;
import lombok.Data;

/**
 * Created by BJLI on 2019/12/22.
 */
@Data
@Builder
public class AuthResponseVO extends BaseVO {
    private String randomKey;
    private String token;

    @Override
    public void checkParam() throws ParamErrorException {

    }
}
