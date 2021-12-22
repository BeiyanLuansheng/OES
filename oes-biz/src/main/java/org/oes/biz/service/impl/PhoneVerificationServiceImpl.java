package org.oes.biz.service.impl;

import org.oes.biz.service.PhoneVerificationService;
import org.oes.common.exception.NotImplementedException;
import org.springframework.stereotype.Service;

@Service
public class PhoneVerificationServiceImpl implements PhoneVerificationService {

    @Override
    public void sendVerificationCode(String phone) {
        // TODO
        throw new NotImplementedException();
    }

    @Override
    public void codeVerification(String phone, String code) {
        //TODO
        throw new NotImplementedException();
    }
}
