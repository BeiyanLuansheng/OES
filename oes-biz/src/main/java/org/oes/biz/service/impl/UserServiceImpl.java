package org.oes.biz.service.impl;

import org.oes.biz.entity.User;
import org.oes.biz.mapper.UserMapper;
import org.oes.biz.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author XuJian
 * @since 2021/12/08
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int createUser(User user) {
        return userMapper.insert(user);
    }
}
