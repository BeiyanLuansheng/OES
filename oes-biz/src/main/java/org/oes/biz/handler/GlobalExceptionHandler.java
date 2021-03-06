package org.oes.biz.handler;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.oes.common.entity.OesHttpResponse;
import org.oes.common.exception.OesControllerException;
import org.oes.common.exception.OesException;
import org.oes.common.exception.OesServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public OesHttpResponse handleException(Exception e) {
        logger.error("系统未知异常，异常信息", e);
        return OesHttpResponse.getFailure("系统未知异常");
    }

    @ExceptionHandler(value = OesException.class)
    public OesHttpResponse handleOesException(OesException e) {
        logger.error("系统内错误", e);
        return OesHttpResponse.getFailure(e.getMessage());
    }

    @ExceptionHandler(value = OesServiceException.class)
    public OesHttpResponse handleOesServiceException(OesServiceException e) {
        logger.error("系统服务异常", e);
        return OesHttpResponse.getFailure(e.getMessage());
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public OesHttpResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        logger.error("服务名或方法错误，不受支持", e);
        return OesHttpResponse.getFailure(e.getMessage());
    }

    /* ======================= 用户错误操作导致的警告 ============================ */

    @ExceptionHandler(value = IncorrectCredentialsException.class)
    public OesHttpResponse handlerIncorrectCredentialsException(IncorrectCredentialsException e) {
        logger.warn("用户登录信息校验失败", e);
        return OesHttpResponse.getFailure(e.getMessage());
    }

    @ExceptionHandler(value = OesControllerException.class)
    public OesHttpResponse handlerOesControllerException(OesControllerException e) {
        logger.warn("信息校验失败", e);
        return OesHttpResponse.getFailure(e.getMessage());
    }
}
