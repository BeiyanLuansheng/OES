package org.oes.biz.service.impl;

import org.oes.biz.component.RedisClient;
import org.oes.biz.service.MailService;
import org.oes.biz.service.VerificationService;
import org.oes.common.exception.OesServiceException;
import org.oes.common.utils.RandomUtils;
import org.oes.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.oes.common.constans.OesConstant.VERIFICATION_PREFIX;

@Service
public class VerificationServiceImpl implements VerificationService {

    private static final Logger logger = LoggerFactory.getLogger(VerificationServiceImpl.class);

    /**
     * 验证码有效时间 300 秒
     */
    @DurationUnit(ChronoUnit.SECONDS)
    private final Duration time = Duration.ofSeconds(300);

    @Resource
    private RedisClient redisClient;
    @Resource
    private MailService mailService;

    @Override
    public int sendPhoneVerificationCode(String phone) {
        String key = VERIFICATION_PREFIX + phone;
        int code = randomCode();
        redisClient.set(key, code + "", time.getSeconds());
        // TODO 发送手机验证码短信
        logger.error("向" + phone + "发送验证码" + code + "未实现");
        return code;
    }

    @Override
    public int sendEmailVerificationCode(String email) {
        String key = VERIFICATION_PREFIX + email;
        int code = randomCode();
        redisClient.set(key, code + "", time.getSeconds());
        // 发送邮箱验证码邮件
        String subject = "在线教育系统验证码";
        String text = "您正在注册在线教育系统，验证码为 " + code + "\n 验证码五分钟内有效，如非本人操作请忽略";
//        mailService.sendSimpleMail(email, subject, text);
        logger.error("向" + email + "发送验证码" + code + "成功");
        return code;
    }

    @Override
    public void codeVerification(String address, String code) {
        if (StringUtils.isBlank(code)) {
            throw new OesServiceException("请输入验证码");
        }
        String key = VERIFICATION_PREFIX + address;
        Object codeInRedis = redisClient.get(key);
        if (codeInRedis == null) {
            throw new OesServiceException("验证码已过期");
        }
        if (!StringUtils.isEquals(code, String.valueOf(codeInRedis))) {
            throw new OesServiceException("验证码不正确");
        }
    }

    /**
     * 随机生成六位数验证码
     */
    private int randomCode() {
        return RandomUtils.randomInt(100000, 1000000);
    }
}
