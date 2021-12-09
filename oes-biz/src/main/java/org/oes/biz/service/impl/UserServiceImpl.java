package org.oes.biz.service.impl;

import org.oes.biz.entity.User;
import org.oes.biz.mapper.UserMapper;
import org.oes.biz.service.UserService;
import org.oes.common.enums.RoleEnum;
import org.oes.common.utils.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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
        user.setGmtCreate(new Date());
        user.setGmtModified(new Date());
        return userMapper.insert(user);
    }

    @Override
    public User findByPhone(String phone) {
        return userMapper.findByPhone(phone);
    }

    /* ================== 登录相关 ================= */

    @Override
    public boolean login(String phone, String password) {
        User user = findByPhone(phone);
        if (user != null) {
            return StringUtils.equals(user.getPassword(), password);
        }
        return false;
    }

    @Override
    public boolean register(String phone,String password) {
        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);
        user.setRoleId(RoleEnum.STUDENT.getCode());
        createUser(user);
        return true;
    }
}
