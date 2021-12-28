package org.oes.start.test;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.oes.biz.service.MailService;
import org.oes.biz.service.VerificationService;
import org.oes.common.constans.ParamKeys;
import org.oes.common.constans.URIs;
import org.oes.common.entity.OesHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class TestController {

    @Resource
    MailService mailService;
    @Resource
    VerificationService verificationService;

    @RequestMapping(path = URIs.TEST, method = RequestMethod.GET)
    @RequiresPermissions("perms:test")
    public OesHttpResponse test() {
        return OesHttpResponse.getSuccess();
    }

    @GetMapping(URIs.GATE)
    public String log() {
        verificationService.sendEmailVerificationCode("beiyanluansheng@qq.com");
        return "发送成功";
    }

    @RequestMapping(value = URIs.GATE, method = RequestMethod.POST)
    public String verify(@RequestBody Map<String, String> params) {
        String code = params.get(ParamKeys.CODE);
        verificationService.codeVerification(params.get(ParamKeys.EMAIL), code);
        return "验证成功";
    }
}
