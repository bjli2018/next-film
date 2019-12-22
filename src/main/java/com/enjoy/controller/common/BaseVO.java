package com.enjoy.controller.common;

import com.enjoy.controller.exception.ParamErrorException;

/**
 * Created by BJLI on 2019/12/22.
 */
public abstract class BaseVO {
    public abstract void checkParam() throws ParamErrorException;
}
