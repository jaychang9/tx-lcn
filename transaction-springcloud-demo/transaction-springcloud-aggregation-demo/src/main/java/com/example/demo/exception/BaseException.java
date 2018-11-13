package com.example.demo.exception;

/**
 * Created with IntelliJ IDEA.
 * User         : zj
 * Date         : 2017/12/23
 * Time         : 下午12:06
 * Description  : 异常基类
 */

public class BaseException extends RuntimeException {

    private int status = 200;

    public BaseException() {}

    public BaseException(String message,int status) {
        super(message);
        this.status = status;
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
