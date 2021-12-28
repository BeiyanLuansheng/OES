package org.oes.common.entity;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * 对前端的请求做出响应
 *
 * @author XuJian
 * @since 2021/12/07
 */
public class OesHttpResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    public OesHttpResponse code(HttpStatus status) {
        this.put("code", status.value());
        return this;
    }

    public OesHttpResponse message(String message) {
        this.put("message", message);
        return this;
    }

    public OesHttpResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    @Override
    public OesHttpResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public static OesHttpResponse getSuccess() {
        return new OesHttpResponse().code(HttpStatus.OK);
    }

    public static OesHttpResponse getSuccess(String message) {
        return OesHttpResponse.getSuccess().message(message);
    }

    public static OesHttpResponse getSuccess(Object data) {
        return OesHttpResponse.getSuccess().data(data);
    }

    public static OesHttpResponse getFailure() {
        return new OesHttpResponse().code(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static OesHttpResponse getFailure(String message) {
        return OesHttpResponse.getFailure().message(message);
    }

    public static OesHttpResponse getFailure(String message, Object data) {
        return OesHttpResponse.getFailure(message).data(data);
    }

    public static OesHttpResponse getUnauthorized() {
        return OesHttpResponse.getUnauthorized("无权限");
    }

    public static OesHttpResponse getUnauthorized(String message) {
        return new OesHttpResponse().code(HttpStatus.UNAUTHORIZED).message(message);
    }
}