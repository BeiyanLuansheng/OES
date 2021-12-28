package org.oes.biz.service.impl;

import org.oes.biz.service.MailService;
import org.oes.common.config.BizConfigurations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MailServiceImpl implements MailService {

    private static final Logger logger = LoggerFactory.getLogger(MailService.class);

    @Resource
    private JavaMailSender mailSender;

    @Override
    public void sendSimpleMail(String mailTo, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(BizConfigurations.mailFrom);
        message.setTo(mailTo);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
        logger.info("邮件已经发送");
    }
}
