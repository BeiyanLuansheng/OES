package org.oes.common.constans;

import java.util.ArrayList;
import java.util.List;

/**
 * 资源地址
 *
 * @author XuJian
 * @since 2021/12/17
 */
public class URIConstant {

    public static final String GATE = "/gate";
    public static final String TEST = "/test";

    public static final String ALL = "/**";

    public static final String LOGIN = "/login";

    public static final String REGISTER = "/register";

    public static final String UNAUTHORIZED = "/unauthorized";

    public static final String LOGOUT = "/logout";

    public static final String SUCCESS = "/success";

    public static final String ROLE = "/role";

    public static final String PERMISSIONS = "/permissions";

    public static final String USER = "/user";

    public static final String COURSE = "/course";
    /**
     *  免认证部分的URL
     */
    public static List<String> unauthorized = new ArrayList<>();
    static {
        unauthorized.add(LOGIN);
        unauthorized.add(REGISTER);
        unauthorized.add(UNAUTHORIZED);
        unauthorized.add(LOGOUT);
        unauthorized.add(SUCCESS);
    }
}
