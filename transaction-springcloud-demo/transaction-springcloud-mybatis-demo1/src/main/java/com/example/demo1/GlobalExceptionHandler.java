package com.example.demo1;

//import com.example.demo1.auth.exception.ClientInvalidException;
//import com.example.demo1.auth.exception.UnauthorizedException;
import com.example.demo1.exception.BizException;
import com.example.demo1.exception.InvalidParameterException;
import com.example.demo1.rest.BaseResponse;
import com.example.demo1.rest.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author xuezhijian
 * @date 2018/8/24 下午6:11
 * @description
 */

@RestControllerAdvice("cn.green")
@ResponseStatus(HttpStatus.OK)
public class GlobalExceptionHandler {
    private static final Logger _LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // 系统异常
    @ExceptionHandler(Exception.class)
    public BaseResponse systemError(Exception ex) {
        _LOG.error(ex.getMessage(),ex);
        return new BaseResponse(ResponseCode.SERVER_ERROR.getCode(),"系统错误,请稍后重试!");
    }

    // 业务异常
    @ExceptionHandler(BizException.class)
    public BaseResponse bizException(BizException ex) {
        _LOG.info(ex.getMessage(),ex);
        return new BaseResponse(ResponseCode.FAILURE.getCode(),ex.getMessage());
    }

    // 参数错误
    @ExceptionHandler({InvalidParameterException.class,IllegalArgumentException.class})
    public BaseResponse parameterError(RuntimeException ex) {
        _LOG.info(ex.getMessage(), ex);
        return new BaseResponse(ResponseCode.PARAM_ERROR.getCode(),ex.getMessage());
    }

//    // 无效客户端
//    @ExceptionHandler(ClientInvalidException.class)
//    public BaseResponse clientError(ClientInvalidException ex) {
//        _LOG.info(ex.getMessage(), ex);
//        return new BaseResponse(ResponseCode.FORBIDDEN.getCode(),ex.getMessage());
//    }
//
//    // 无效授权
//    @ExceptionHandler(UnauthorizedException.class)
//    public BaseResponse unauthorizedError(UnauthorizedException ex) {
//        _LOG.info(ex.getMessage(), ex);
//        return new BaseResponse(ResponseCode.UNAUTHORIZED.getCode(),ex.getMessage());
//    }

}
