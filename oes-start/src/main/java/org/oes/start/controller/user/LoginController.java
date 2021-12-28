package org.oes.start.controller.user;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.oes.biz.service.VerificationService;
import org.oes.biz.service.UserService;
import org.oes.common.constans.ParamKeys;
import org.oes.common.constans.URIs;
import org.oes.common.entity.OesHttpResponse;
import org.oes.common.exception.OesControllerException;
import org.oes.common.utils.MD5Utils;
import org.oes.start.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 负责用户登录前及登出后的行为控制
 *
 * @author XuJian
 * @since 2021/12/09
 */
@RestController
public class LoginController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private UserService userService;
    @Resource
    private VerificationService verificationService;

    /**
     * 登录
     *
     * @param params 包含手机号、密码，记住我三个值
     * @param request request
     * @return 登陆成功返回200，失败抛出异常
     */
    @RequestMapping(path = URIs.LOGIN, method = RequestMethod.POST)
//    @Limit(key = "login", period = 60, count = 10, name = "登录接口", prefix = "limit")
    public OesHttpResponse login(@RequestBody Map<String, Object> params, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = (String) params.get(ParamKeys.EMAIL);
        String password = (String) params.get(ParamKeys.PWD);
        boolean rememberMe = !params.containsKey(ParamKeys.REMEMBER) || (boolean) params.get(ParamKeys.REMEMBER);
        String md5Password = MD5Utils.encrypt(email.toLowerCase(), password);
        UsernamePasswordToken token = new UsernamePasswordToken(email, md5Password, rememberMe);
        super.login(token);
        return OesHttpResponse.getSuccess();
    }

    /**
     * 发起注册
     *
     * @param params 用户填入的邮箱
     * @return 注册成功返回200，失败抛出异常
     */
    @RequestMapping(path = URIs.REGISTER, method = RequestMethod.POST)
    public OesHttpResponse register(@RequestBody Map<String, String> params) {
        String email = params.get(ParamKeys.EMAIL);
        if (userService.isEmailRegistered(email)) {
            throw new OesControllerException("该邮箱已被注册过，不能重复注册");
        }
        verificationService.sendEmailVerificationCode(email);
        return OesHttpResponse.getSuccess();
    }

    /**
     * 忘记密码，获取验证码以重新设置密码
     *
     * @param params 邮箱
     * @return 获取成功返回200，失败抛出异常
     */
    @RequestMapping(path = URIs.FORGET, method = RequestMethod.POST)
    public OesHttpResponse forgetPassword(@RequestBody Map<String, String> params) {
        String email = params.get(ParamKeys.EMAIL);
        if (!userService.isEmailRegistered(email)) {
            throw new OesControllerException("该邮箱未注册");
        }
        verificationService.sendEmailVerificationCode(email);
        return OesHttpResponse.getSuccess();
    }

    /**
     * 验证手机验证码
     * - 初次绑定
     * - 忘记密码
     * - 修改密码（可选）
     *
     * @param params 手机号和收到的验证码
     * @return 验证成功返回200，失败抛出异常
     */
    @RequestMapping(path = URIs.PHONE_VERIFICATION, method = RequestMethod.POST)
    public OesHttpResponse phoneVerification(@RequestBody Map<String, String> params) {
        String phone = params.get(ParamKeys.PHONE);
        String code = params.get(ParamKeys.CODE);
        verificationService.codeVerification(phone, code);
        // 在数据库中注册
        userService.register(phone);
        return OesHttpResponse.getSuccess();
    }

    /**
     * 验证邮箱验证码
     * - 初次绑定
     * - 忘记密码
     * - 修改密码（可选）
     *
     * @param params 手机号和收到的验证码
     * @return 验证成功返回200，失败抛出异常
     */
    @RequestMapping(path = URIs.EMAIL_VERIFICATION, method = RequestMethod.POST)
    public OesHttpResponse emailVerification(@RequestBody Map<String, String> params) {
        String email = params.get(ParamKeys.EMAIL);
        String code = params.get(ParamKeys.CODE);
        if (userService.isEmailRegistered(email)) {
            throw new OesControllerException("该邮箱已被注册过，不能重复注册");
        }
        verificationService.codeVerification(email, code);
        // 在数据库中注册
        userService.register(email);
        return OesHttpResponse.getSuccess();
    }

    /**
     * 注册成功后首次设置密码
     *
     * @param params 邮箱和密码
     * @return 成功返回200，失败抛出异常
     */
    @RequestMapping(path = URIs.PASSWORD, method = RequestMethod.POST)
    public OesHttpResponse setPassword(@RequestBody Map<String, String> params) {
        String email = params.get(ParamKeys.EMAIL);
        String pwd = params.get(ParamKeys.PWD);
        userService.updatePassword(email, pwd);
        return OesHttpResponse.getSuccess();
    }

    /* ============================ 异常行为跳转 =============================== */
    /**
     * 未授权
     */
    @RequestMapping(path = URIs.UNAUTHORIZED, method = RequestMethod.GET)
    public OesHttpResponse unauthorized() {
        return OesHttpResponse.getUnauthorized();
    }

    /**
     * 需要登录认证
     */
    @RequestMapping(path = URIs.LOGIN, method = RequestMethod.GET)
    public OesHttpResponse login() {
        return OesHttpResponse.getUnauthorized("请先登录");
    }

    /**
     * 操作成功跳转
     */
    @RequestMapping(path = URIs.SUCCESS, method = RequestMethod.GET)
    public OesHttpResponse success() {
        return OesHttpResponse.getSuccess("操作成功");
    }
}
