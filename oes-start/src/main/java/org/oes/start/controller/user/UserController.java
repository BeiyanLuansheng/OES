package org.oes.start.controller.user;

import org.oes.biz.entity.User;
import org.oes.biz.service.UserService;
import org.oes.common.constans.URIs;
import org.oes.common.entity.OesHttpResponse;
import org.oes.common.utils.MD5Utils;
import org.oes.common.utils.StringUtils;
import org.oes.start.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户控制
 *
 * @author XuJian
 * @since 2021/12/09
 */
@RestController
@RequestMapping(URIs.USER)
public class UserController extends BaseController {

    @Resource
    private UserService userService;

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
