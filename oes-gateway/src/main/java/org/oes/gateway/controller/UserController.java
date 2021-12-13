package org.oes.gateway.controller;

import org.oes.biz.entity.User;
import org.oes.biz.service.UserService;
import org.oes.common.entity.OesHttpResponse;
import org.oes.common.utils.MD5Utils;
import org.oes.common.utils.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @RequestMapping(path = "test", method = RequestMethod.GET)
    public OesHttpResponse testUser() {
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(path = "password", method = RequestMethod.PUT)
    public OesHttpResponse updatePassword(@RequestParam("oldPwd") String oldPwd,
                                          @RequestParam("newPwd") String newPwd,
                                          HttpServletRequest request) {
        User user = getCurrentUser();
        if (StringUtils.isNotEquals(MD5Utils.encrypt(user.getPhone(), oldPwd), user.getPassword())) {
            return OesHttpResponse.getFailure("原密码不正确");
        }
        userService.updatePassword(user.getPhone(), newPwd);
        return OesHttpResponse.getSuccess();
    }
}
