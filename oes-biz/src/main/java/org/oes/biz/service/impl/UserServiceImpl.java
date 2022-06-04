package org.oes.biz.service.impl;

import org.oes.biz.entity.Permissions;
import org.oes.biz.entity.User;
import org.oes.biz.mapper.UserMapper;
import org.oes.biz.service.PermissionsService;
import org.oes.biz.service.RoleService;
import org.oes.biz.service.UserService;
import org.oes.common.enums.RoleEnum;
import org.oes.common.enums.UserStatusEnum;
import org.oes.common.utils.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author XuJian
 * @since 2021/12/08
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    /**
     * 默认密码
     */
    private static final String DEFAULT_PASSWORD = "DEFAULT_PASSWORD";

    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleService roleService;
    @Resource
    private PermissionsService permissionsService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int createUser(User user) {
        user.setGmtCreate(new Date());
        user.setGmtModified(new Date());
        return userMapper.insert(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User getById(Long userId) {
        User user = userMapper.findById(userId);
        user.setPassword(null);
        user.setStatus(null);
        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(User user) {
        userMapper.updateById(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(MD5Utils.encrypt(email, password));
        user.setGmtModified(new Date());
        userMapper.updateByEmail(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAvatar(Long userId, String avatar) {
        User user = new User();
        user.setUserId(userId);
        user.setAvatar(avatar);
        user.setGmtModified(new Date());
        userMapper.updateById(user);
    }

    @Override
    public User findByPhone(String phone) {
        return userMapper.findByPhone(phone);
    }
    @Override
    public User findByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    /* ================== 登录注册相关 ================= */

    @Override
    public boolean isPhoneRegistered(String phone) {
        return this.findByPhone(phone) != null;
    }

    @Override
    public boolean isEmailRegistered(String email) {
        return this.findByEmail(email) != null;
    }

    @Override
    public void register(String email) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(MD5Utils.encrypt(email, DEFAULT_PASSWORD));
        user.setRoleId(RoleEnum.STUDENT.getCode());
        user.setStatus(UserStatusEnum.WAITING_FOR_PASSWORD.getCode());
        this.createUser(user);
    }

    @Override
    public void register(String email,String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(MD5Utils.encrypt(email, password));
        user.setRoleId(RoleEnum.STUDENT.getCode());
        user.setStatus(UserStatusEnum.VALID.getCode());
        this.createUser(user);
    }

    @Override
    public User doGetUserAuthorization(User user) {
        // 获取用户角色集
        user = userMapper.findByEmail(user.getEmail());
        Set<String> roleSet = new HashSet<>();
        String roleName = roleService.findRoleById(user.getRoleId()).getRoleName();
        roleSet.add(roleName);
        user.setRoleNames(roleSet);
        // 获取用户权限集
        List<Permissions> permissionList = permissionsService.findRolePermissions(user.getRoleId());
        Set<String> permissionsSet = permissionList.stream().map(Permissions::getPermissions).collect(Collectors.toSet());
        user.setPermissions(permissionsSet);
        return user;
    }
}
