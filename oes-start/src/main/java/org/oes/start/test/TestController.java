package org.oes.start.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.oes.biz.service.FileService;
import org.oes.biz.service.MailService;
import org.oes.biz.service.VerificationService;
import org.oes.common.constans.ParamKeys;
import org.oes.common.constans.URIs;
import org.oes.common.entity.OesHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Resource
    MailService mailService;
    @Resource
    VerificationService verificationService;
    @Resource
    FileService fileService;

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

    @RequestMapping(value = "file/upload", method = RequestMethod.POST)
    public String fileUp(@RequestParam("files") MultipartFile[] files) {
        JSONObject object=new JSONObject();
        for (MultipartFile file : files) {
            fileService.uploadFile(file, null);
        }
        object.put("success",1);
        object.put("result","文件上传成功");
        return object.toString();
    }
}
