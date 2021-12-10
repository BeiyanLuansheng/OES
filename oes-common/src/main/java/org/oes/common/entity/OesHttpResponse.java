package org.oes.common.entity;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
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

    public static OesHttpResponse getFailure(String message) {
        return new OesHttpResponse().code(HttpStatus.INTERNAL_SERVER_ERROR).message(message);
    }
}