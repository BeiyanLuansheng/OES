package org.oes.common.exception;

/**
 * 系统服务内部异常
 *
 * @author XuJian
 * @since 2021/12/10
 */
public class OesServiceException extends OesException {

    private static final long serialVersionUID = -994962710559017254L;

    public OesServiceException(String message) {
        super(message);
    }
}
