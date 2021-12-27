package org.oes.biz.service.impl;

import org.oes.biz.component.RedisClient;
import org.oes.biz.service.PhoneVerificationService;
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
public class PhoneVerificationServiceImpl implements PhoneVerificationService {

    private static final Logger logger = LoggerFactory.getLogger(PhoneVerificationServiceImpl.class);

    /**
     * 验证码有效时间 300 秒
     */
    @DurationUnit(ChronoUnit.SECONDS)
    private final Duration time = Duration.ofSeconds(300);

    @Resource
    private RedisClient redisClient;

    @Override
    public int sendVerificationCode(String phone) {
        String key = VERIFICATION_PREFIX + phone;
        int code = randomCode();
        redisClient.set(key, code + "", time.getSeconds());
        // TODO 发送手机验证码短信
        logger.error("向" + phone + "发送验证码" + code + "未实现");
        return code;
    }

    @Override
    public void codeVerification(String phone, String code) {
        if (StringUtils.isBlank(code)) {
            throw new OesServiceException("请输入验证码");
        }
        String key = VERIFICATION_PREFIX + phone;
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
