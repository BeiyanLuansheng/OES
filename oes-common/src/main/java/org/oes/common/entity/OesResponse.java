package org.oes.common.entity;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * @author XuJian
 * @since 2021/12/07
 */
public class OesResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    public OesResponse code(HttpStatus status) {
        this.put("code", status.value());
        return this;
    }

    public OesResponse message(String message) {
        this.put("message", message);
        return this;
    }

    public OesResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    public OesResponse success() {
        this.code(HttpStatus.OK);
        return this;
    }

    public OesResponse fail() {
        this.code(HttpStatus.INTERNAL_SERVER_ERROR);
        return this;
    }

    @Override
    public OesResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}