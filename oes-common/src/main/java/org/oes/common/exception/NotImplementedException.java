package org.oes.common.exception;

/**
 * 方法还没有实现抛出异常
 *
 * @author XuJian
 * @since 2021/12/22
 */
public class NotImplementedException extends OesException {

    private static final long serialVersionUID = -1494455096501175489L;

    public NotImplementedException() {
        super();
    }

    public NotImplementedException(String message) {
        super(message);
    }
}
