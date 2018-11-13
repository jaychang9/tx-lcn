package com.example.demo2.rest;

/**
 * @author xuezhijian
 * @date 2018/8/30 下午6:28
 * @description
 */

public enum ResponseCode {

    // 成功
    SUCCESS(200,"SUCCESS"),
    // 失败
    FAILURE(400,"FAILURE"),
    // 参数错误
    PARAM_ERROR(414,"PARAM_ERROR"),
    // 系统内部错误
    SERVER_ERROR(500,"SERVER_ERROR"),
    // 服务降级
    SERVICE_MOCK(512,"SERVICE_MOCK"),
    // 未授权
    UNAUTHORIZED(401,"UNAUTHORIZED"),
    // 无效客户端
    FORBIDDEN(403,"FORBIDDEN");

    private final int code;
    private final String desc;


    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

}
