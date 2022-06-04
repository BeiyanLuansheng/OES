package org.oes.start.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.oes.biz.config.OesBizConfig;
import org.oes.biz.entity.User;
import org.oes.biz.service.FileService;
import org.oes.biz.service.MailService;
import org.oes.biz.service.UserService;
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
    @Resource
    OesBizConfig oesBizConfig;

    @RequestMapping(path = URIs.TEST, method = RequestMethod.GET)
    @RequiresPermissions("perms:test")
    public OesHttpResponse test() {
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(path = URIs.TEST, method = RequestMethod.POST)
    @RequiresPermissions("perms:test2")
    public OesHttpResponse test2() {
        return OesHttpResponse.getSuccess("权限校验成功");
    }

    @GetMapping(URIs.GATE)
    public OesHttpResponse gate() {
//        verificationService.sendEmailVerificationCode("beiyanluansheng@qq.com");
        return OesHttpResponse.getSuccess(oesBizConfig.getMinioEndpoint());
    }

//    @RequestMapping(value = "file/upload", method = RequestMethod.POST)
//    public String fileUp(@RequestParam("files") MultipartFile[] files) {
//        for (MultipartFile file : files) {
//            fileService.uploadFile(file, file.getOriginalFilename(), "test");
//        }
//        return "文件上传成功";
//    }
}
