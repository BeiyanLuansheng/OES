package org.oes.common.exception;

/**
 * 在 Controller 中直接校验失败
 */
public class OesControllerException extends OesException {

    private static final long serialVersionUID = 2021767521755617436L;

    public OesControllerException(String message) {
        super(message);
    }
}
