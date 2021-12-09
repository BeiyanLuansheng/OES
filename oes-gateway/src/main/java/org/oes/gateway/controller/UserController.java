package org.oes.gateway.controller;

import org.oes.biz.entity.User;
import org.oes.biz.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController("user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("create")
    public User createUser(User user) {
        user.setGmtCreate(new Date());
        userService.createUser(user);
        return user;
    }
}
