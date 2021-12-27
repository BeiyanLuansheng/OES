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
import org.oes.common.utils.StringUtils;
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
    public void updatePassword(String phone, String password) {
        User user = new User();
        user.setPhone(phone);
        user.setPassword(MD5Utils.encrypt(phone, password));
        user.setGmtModified(new Date());
        userMapper.updateByPhone(user);
    }

    @Override
    public User findByPhone(String phone) {
        return userMapper.findByPhone(phone);
    }

    /* ================== 登录注册相关 ================= */

    @Override
    public void register(String phone) {
        register(phone, DEFAULT_PASSWORD);
    }

    @Override
    public void register(String phone,String password) {
        User user = new User();
        user.setPhone(phone);
        user.setPassword(MD5Utils.encrypt(phone, password));
        user.setRoleId(RoleEnum.STUDENT.getCode());
        user.setStatus(UserStatusEnum.WAITING_FOR_PASSWORD.getCode());
        this.createUser(user);
    }

    @Override
    public boolean isRegistered(String phone) {
        return this.findByPhone(phone) != null;
    }

    @Override
    public User doGetUserAuthorization(User user) {
        // 获取用户角色集
        Set<String> roleSet = new HashSet<>();
        String roleName = roleService.findRoleById(user.getRoleId()).getRoleName();
        roleSet.add(roleName);
        user.setRoleNames(roleSet);
        // 获取用户权限集
        List<Permissions> permissionList = permissionsService.findRolePermissions(user.getRoleId());
        Set<String> permissionsSet = permissionList.stream().map(Permissions::getPermissions).collect(Collectors.toSet());
        user.setRoleNames(permissionsSet);
        return user;
    }
}
