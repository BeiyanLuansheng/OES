package org.oes.common.exception;

/**
 * 系统内部异常
 *
 * @author XuJian
 * @since 2021/12/07
 */
public class OesException extends RuntimeException  {

    private static final long serialVersionUID = -994962710559017255L;

    public OesException() {
        super();
    }

    public OesException(String message) {
        super(message);
    }
}
