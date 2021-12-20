package org.oes.start.controller;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.oes.biz.entity.User;
import org.oes.biz.service.UserService;
import org.oes.common.constans.URIConstant;
import org.oes.common.entity.OesHttpResponse;
import org.oes.common.utils.MD5Utils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 负责用户登录前及登出后的行为控制
 *
 * @author XuJian
 * @since 2021/12/09
 */
@RestController
public class LoginController extends BaseController {

    @Resource
    private UserService userService;

    /**
     * 登录
     *
     * @param phone
     * @param password
     * @param rememberMe
     * @param request
     * @return
     */
    @RequestMapping(path = URIConstant.LOGIN, method = RequestMethod.POST)
//    @Limit(key = "login", period = 60, count = 10, name = "登录接口", prefix = "limit")
    public OesHttpResponse login(@RequestParam String phone,
                                 @RequestParam String password,
            boolean rememberMe, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String md5Password = MD5Utils.encrypt(phone.toLowerCase(), password);
        UsernamePasswordToken token = new UsernamePasswordToken(phone, md5Password, rememberMe);
        super.login(token);
        return OesHttpResponse.getSuccess();
    }

    /**
     * 注册
     *
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping(path = URIConstant.REGISTER, method = RequestMethod.POST)
    public OesHttpResponse register(@RequestParam String phone,
                                    @RequestParam String password) {
        User user = userService.findByPhone(phone);
        if (user != null) {
            return OesHttpResponse.getFailure("该手机号已被注册过");
        }
        userService.register(phone, password);
        return OesHttpResponse.getSuccess();
    }

    /* ============================ 异常行为跳转 =============================== */
    /**
     * 未授权
     */
    @RequestMapping(path = URIConstant.UNAUTHORIZED, method = RequestMethod.GET)
    public OesHttpResponse unauthorized() {
        return new OesHttpResponse().code(HttpStatus.UNAUTHORIZED).message("");
    }

    /**
     * 需要登录认证
     */
    @RequestMapping(path = URIConstant.LOGIN, method = RequestMethod.GET)
    public OesHttpResponse login() {
        return OesHttpResponse.getSuccess("请先登录");
    }

    /**
     * 操作成功跳转
     */
    @RequestMapping(path = URIConstant.SUCCESS, method = RequestMethod.GET)
    public OesHttpResponse success() {
        return OesHttpResponse.getSuccess("操作成功");
    }
}
