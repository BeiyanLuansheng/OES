package org.oes.biz.service;

/**
 * 手机验证服务
 *
 * @author XuJian
 * @since 2021/12/22
 */
public interface PhoneVerificationService {

    /**
     * 给手机号发送验证码
     *
     * @param phone 手机号
     */
    void sendVerificationCode(String phone);

    /**
     * 验证手机号的验证码
     */
    void codeVerification(String phone, String code);
}
