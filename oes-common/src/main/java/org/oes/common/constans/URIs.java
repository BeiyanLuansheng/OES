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
     * 设置密码
     */
    public static final String PASSWORD = "/password";

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
    public static final String AVATAR = "/avatar";
    public static final String INFO = "/info";

    /**
     * 课程操作
     */
    public static final String COURSE = "/course";
    public static final String CHAPTER = "/chapter";
    public static final String FILE = "/file";
    public static final String JOIN = "/join";
    public static final String COMMENT = "/comment";
    public static final String EXAM = "/exam";
    public static final String NOTICE = "/notice";
    public static final String RANDOM = "/random";
    public static final String ORDER = "/order";
    /**
     * 详情
     */
    public static final String DETAIL = "/detail";
    /**
     * 首页轮播
     */
    public static final String BANNER = "/banner";
    /**
     * 分类
     */
    public static final String CATEGORY = "/category";

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
        unauthorized.add("/druid/**");

        unauthorized.add(GATE);
    }
}
