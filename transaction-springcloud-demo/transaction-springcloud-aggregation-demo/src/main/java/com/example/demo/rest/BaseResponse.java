package com.example.demo.rest;


import com.example.demo.util.SystemClock;

import java.sql.Timestamp;

/**
 * @author xuezhijian
 * @date 2018/7/28 下午5:06
 * @description
 */

public class BaseResponse {

    private int status = ResponseCode.SUCCESS.getCode();

    private String message;

    private Long currentTime = new Timestamp(SystemClock.now()).getTime();

    public BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponse message(String message) {
        this.message = message;
        return this;
    }

    public BaseResponse() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
    }

}
