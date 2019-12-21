package com.enjoy.controller.exception;

import lombok.Data;

/**
 * Created by BJLI on 2019/12/22.
 */
@Data
public class NextFilmException extends Exception {
    private Integer code;
    private String errMsg;

    public NextFilmException(int code, String errMsg){
        super(errMsg);
        this.code = code;
        this.errMsg = errMsg;
    }
}
