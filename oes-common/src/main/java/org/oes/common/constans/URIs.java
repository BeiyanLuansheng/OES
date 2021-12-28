package org.oes.common.constans;

import java.util.ArrayList;
import java.util.List;

/**
 * 资源地址
 *
 * @author XuJian
 * @since 2021/12/17
 */
public class URIs {

    public static final String GATE = "/gate";
    public static final String TEST = "/test";

    public static final String ALL = "/**";

    /**
     * 登录
     */
    public static final String LOGIN = "/login";

    /**
     * 注册
     */
    public static final String REGISTER = "/register";

    /**
     * 忘记密码
     */
    public static final String FORGET = "/forget";

    /**
     * 验证手机验证码
     */
    public static final String PHONE_VERIFICATION = "/phone";

    /**
     * 验证邮箱验证码
     */
    public static final String EMAIL_VERIFICATION = "/email";

    /**
     * 未授权
     */
    public static final String UNAUTHORIZED = "/unauthorized";

    /**
     * 登出
     */
    public static final String LOGOUT = "/logout";

    /**
     * 登录成功
     */
    public static final String SUCCESS = "/success";

    /**
     * 角色操作
     */
    public static final String ROLE = "/role";

    /**
     * 权限操作
     */
    public static final String PERMISSIONS = "/permissions";

    /**
     * 用户操作
     */
    public static final String USER = "/user";

    /**
     * 课程操作
     */
    public static final String COURSE = "/course";
    /**
     *  免认证部分的URL
     */
    public static List<String> unauthorized = new ArrayList<>();
    static {
        unauthorized.add(LOGIN);
        unauthorized.add(REGISTER);
        unauthorized.add(PHONE_VERIFICATION);
        unauthorized.add(EMAIL_VERIFICATION);
        unauthorized.add(UNAUTHORIZED);
        unauthorized.add(SUCCESS);

        unauthorized.add(GATE);
    }
}
