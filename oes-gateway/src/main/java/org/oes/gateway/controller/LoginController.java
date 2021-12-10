package org.oes.gateway.controller;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.oes.biz.entity.User;
import org.oes.biz.service.UserService;
import org.oes.common.entity.OesHttpResponse;
import org.oes.common.utils.MD5Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotBlank;

@RestController
public class LoginController extends BaseController {

    @Resource
    private UserService userService;
//    private LoginLogService loginLogService;

    @RequestMapping(path = "login", method = RequestMethod.POST)
//    @Limit(key = "login", period = 60, count = 10, name = "登录接口", prefix = "limit")
    public OesHttpResponse login(@RequestParam String phone,
                                 @RequestParam String password,
            boolean rememberMe, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String md5Password = MD5Utils.encrypt(phone.toLowerCase(), password);
        UsernamePasswordToken token = new UsernamePasswordToken(phone, password, rememberMe);
        super.login(token);
        if (!userService.login(phone, md5Password)) {
            return OesHttpResponse.getFailure("用户名或密码错误");
        }
        // 保存登录日志
//        LoginLog loginLog = new LoginLog();
//        loginLog.setUsername(username);
//        loginLog.setSystemBrowserInfo();
//        this.loginLogService.saveLoginLog(loginLog);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(path = "register", method = RequestMethod.POST)
    public OesHttpResponse register(@RequestParam String phone,
                                    @RequestParam String password) {
        User user = userService.findByPhone(phone);
        if (user != null) {
            return OesHttpResponse.getFailure("该手机号已被注册过");
        }
        userService.register(phone, password);
        return OesHttpResponse.getSuccess();
    }

//    @GetMapping("images/captcha")
//    @Limit(key = "get_captcha", period = 60, count = 10, name = "获取验证码", prefix = "limit")
//    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException, OesException {
//        validateCodeService.create(request, response);
//    }

//    private Subject getSubject() {
//        return SecurityUtils.getSubject();
//    }

}
