package com.example.demo.exception;

/**
 * Created with IntelliJ IDEA.
 * User         : zj
 * Date         : 2017/12/21
 * Time         : 下午4:40
 * Description  : 无效参数异常
 */

public class InvalidParameterException extends BaseException {

    public InvalidParameterException(String message, Object... params) {
        super(String.format(message, params));
    }
}
