package org.oes.biz.handler;

import org.oes.common.entity.OesHttpResponse;
import org.oes.common.exception.OesException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public OesHttpResponse handleException(Exception e) {
        logger.error("系统内部异常，异常信息", e);
        return OesHttpResponse.getFailure("系统内部异常");
    }

    @ExceptionHandler(value = OesException.class)
    public OesHttpResponse handleOesException(OesException e) {
        logger.error("系统错误", e);
        return OesHttpResponse.getFailure(e.getMessage());
    }
}