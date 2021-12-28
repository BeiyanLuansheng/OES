package org.oes.biz.service;

/**
 * 手机/邮箱验证服务
 *
 * @author XuJian
 * @since 2021/12/22
 */
public interface VerificationService {

    /**
     * 给手机号发送验证码
     *
     * @param phone 手机号
     */
    int sendPhoneVerificationCode(String phone);

    /**
     * 给手邮箱发送验证码
     *
     * @param email 邮箱
     */
    int sendEmailVerificationCode(String email);

    /**
     * 验证手机号的验证码
     *
     * @param address 手机号或邮箱
     * @param code 验证码
     */
    void codeVerification(String address, String code);
}
