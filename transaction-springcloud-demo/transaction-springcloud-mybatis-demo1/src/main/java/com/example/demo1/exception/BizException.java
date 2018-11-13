package com.example.demo1.exception;

/**
 * Created with IntelliJ IDEA.
 * User         : zj
 * Date         : 17/6/21
 * Time         : 下午10:31
 * Description  : 业务异常基类
 */

public class BizException extends BaseException {

    public BizException(String message, Object... params) {
        super(String.format(message, params));
    }

}
