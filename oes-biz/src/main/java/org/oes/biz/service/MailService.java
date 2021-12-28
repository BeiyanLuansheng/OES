package org.oes.biz.service;

/**
 * 邮件服务
 *
 * @author XuJian
 * @since 2021/12/28
 */
public interface MailService {

    /**
     * 发送简单文本邮件
     *
     * @param mailTo 邮件地址
     * @param subject 邮件主题
     * @param text 邮件内容
     */
    void sendSimpleMail(String mailTo, String subject, String text);
}
