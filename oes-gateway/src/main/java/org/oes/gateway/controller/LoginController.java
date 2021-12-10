package org.oes.gateway.controller;

import org.oes.biz.entity.User;
import org.oes.biz.service.UserService;
import org.oes.common.entity.OesHttpResponse;
import org.oes.common.exception.OesException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotBlank;

@RestController
public class LoginController {

    @GetMapping("testLogin")
    public OesHttpResponse test() {
        return OesHttpResponse.getSuccess();
    }

    @Resource
    private UserService userService;
//    private LoginLogService loginLogService;

    @PostMapping("login")
//    @Limit(key = "login", period = 60, count = 10, name = "登录接口", prefix = "limit")
    public OesHttpResponse login(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password,
            boolean rememberMe, HttpServletRequest request) throws OesException {
        HttpSession session = request.getSession();
//        password = Md5Util.encrypt(username.toLowerCase(), password);
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
//        super.login(token);
        if (!userService.login(username, password)) {
            throw new OesException("用户名或密码错误");
        }
        // 保存登录日志
//        LoginLog loginLog = new LoginLog();
//        loginLog.setUsername(username);
//        loginLog.setSystemBrowserInfo();
//        this.loginLogService.saveLoginLog(loginLog);
        return OesHttpResponse.getSuccess();
    }

    @PostMapping("register")
    public OesHttpResponse register(
            @NotBlank(message = "{required}") String phone,
            @NotBlank(message = "{required}") String password) throws OesException {
        User user = userService.findByPhone(phone);
        OesHttpResponse response = new OesHttpResponse();
        if (user != null) {
            throw new OesException("该手机号已被注册过");
//            response.message("该手机号已被注册过");
//            return new
        }
        this.userService.register(phone, password);
        return OesHttpResponse.getSuccess();
    }
//
//    @GetMapping("index/{username}")
//    public FebsResponse index(@NotBlank(message = "{required}") @PathVariable String username) {
//        // 更新登录时间
//        this.userService.updateLoginTime(username);
//        Map<String, Object> data = new HashMap<>(5);
//        // 获取系统访问记录
//        Long totalVisitCount = this.loginLogService.findTotalVisitCount();
//        data.put("totalVisitCount", totalVisitCount);
//        Long todayVisitCount = this.loginLogService.findTodayVisitCount();
//        data.put("todayVisitCount", todayVisitCount);
//        Long todayIp = this.loginLogService.findTodayIp();
//        data.put("todayIp", todayIp);
//        // 获取近期系统访问记录
//        List<Map<String, Object>> lastSevenVisitCount = this.loginLogService.findLastSevenDaysVisitCount(null);
//        data.put("lastSevenVisitCount", lastSevenVisitCount);
//        User param = new User();
//        param.setUsername(username);
//        List<Map<String, Object>> lastSevenUserVisitCount = this.loginLogService.findLastSevenDaysVisitCount(param);
//        data.put("lastSevenUserVisitCount", lastSevenUserVisitCount);
//        return new FebsResponse().success().data(data);
//    }

//    @GetMapping("images/captcha")
//    @Limit(key = "get_captcha", period = 60, count = 10, name = "获取验证码", prefix = "limit")
//    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException, FebsException {
//        validateCodeService.create(request, response);
//    }

//    private Subject getSubject() {
//        return SecurityUtils.getSubject();
//    }

}
