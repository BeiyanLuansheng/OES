package org.oes.gateway.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.oes.biz.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 登录用户获取
 *
 * @author XuJian
 * @since 2021/12/10
 */
public class BaseController {

    protected static Logger LOG = LoggerFactory.getLogger(BaseController.class);

    private Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    protected User getCurrentUser() {
        return (User) getSubject().getPrincipal();
    }

    protected void login(AuthenticationToken token) {
        getSubject().login(token);
    }
}
