package com.enjoy.controller.common.handler;

import com.enjoy.controller.common.BaseResponseVO;
import com.enjoy.controller.exception.NextFilmException;
import com.enjoy.service.common.exception.CommonServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by BJLI on 2019/12/22.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NextFilmException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BaseResponseVO nextFilmException(NextFilmException e){
        return BaseResponseVO.serviceFailed(e.getErrMsg());
    }

    @ExceptionHandler(CommonServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BaseResponseVO commonServiceException(CommonServiceException e){
        return BaseResponseVO.serviceFailed(e.getCode(),e.getErrMsg());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BaseResponseVO exception(Exception e){
        return BaseResponseVO.systemError();
    }
}
