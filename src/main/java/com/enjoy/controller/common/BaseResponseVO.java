package com.enjoy.controller.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by BJLI on 2019/12/21.
 */
@Data
@AllArgsConstructor
public final class BaseResponseVO<M> {
    private BaseResponseVO(){}

    private int status;
    private String msg;
    private M data;

    public static<M> BaseResponseVO success(){
        BaseResponseVO baseResponseVO = new BaseResponseVO();
        baseResponseVO.setStatus(0);
        return baseResponseVO;
    }

    public static<M> BaseResponseVO success(String msg){
        BaseResponseVO baseResponseVO = new BaseResponseVO();
        baseResponseVO.setStatus(0);
        baseResponseVO.setMsg(msg);
        return baseResponseVO;
    }

    public static<M> BaseResponseVO success(M data){
        BaseResponseVO baseResponseVO = new BaseResponseVO();
        baseResponseVO.setStatus(0);
        baseResponseVO.setData(data);
        return baseResponseVO;
    }

    public static<M> BaseResponseVO success(String msg,M data){
        BaseResponseVO baseResponseVO = new BaseResponseVO();
        baseResponseVO.setStatus(0);
        baseResponseVO.setMsg(msg);
        baseResponseVO.setData(data);
        return baseResponseVO;
    }

    public static<M> BaseResponseVO serviceFailed(String msg){
        BaseResponseVO baseResponseVO = new BaseResponseVO();
        baseResponseVO.setStatus(1);
        baseResponseVO.setMsg(msg);
        return baseResponseVO;
    }

    public static<M> BaseResponseVO serviceFailed(int status,String msg){
        BaseResponseVO baseResponseVO = new BaseResponseVO();
        baseResponseVO.setStatus(status);
        baseResponseVO.setMsg(msg);
        return baseResponseVO;
    }

    public static<M> BaseResponseVO noLogin(){
        BaseResponseVO baseResponseVO = new BaseResponseVO();
        baseResponseVO.setStatus(777);
        baseResponseVO.setMsg("用户需要登陆");
        return baseResponseVO;
    }

    public static<M> BaseResponseVO noLogin(String msg,M data){
        BaseResponseVO baseResponseVO = new BaseResponseVO();
        baseResponseVO.setStatus(777);
        baseResponseVO.setMsg("用户需要登陆");
        return baseResponseVO;
    }

    public static<M> BaseResponseVO serviceFailed(String msg,M data){
        BaseResponseVO baseResponseVO = new BaseResponseVO();
        baseResponseVO.setStatus(1);
        baseResponseVO.setMsg(msg);
        baseResponseVO.setData(data);
        return baseResponseVO;
    }

    public static<M> BaseResponseVO systemError(){
        BaseResponseVO baseResponseVO = new BaseResponseVO();
        baseResponseVO.setStatus(999);
        baseResponseVO.setMsg("系统异常，请联系管理员");
        return baseResponseVO;
    }
}
