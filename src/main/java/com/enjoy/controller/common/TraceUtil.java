package com.enjoy.controller.common;

/**
 * Created by BJLI on 2019/12/22.
 */
public final class TraceUtil {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private TraceUtil(){}

    public static void initThread(String userId){
        threadLocal.set(userId);
    }

    public static String getUserId(){
        return threadLocal.get();
    }
}
