package org.oes.gateway.controller;

import org.oes.biz.entity.User;
import org.oes.biz.service.UserService;
import org.oes.common.entity.OesHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("testUser")
    public OesHttpResponse testUser() {
        return OesHttpResponse.getSuccess();
    }
}
