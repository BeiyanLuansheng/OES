package org.oes.biz.service;

import org.oes.biz.entity.User;

/**
 * @author XuJian
 * @since 2021/12/08
 */
public interface UserService {

    int createUser(User user);

    void updatePassword(String phone, String password);

    User findByPhone(String phone);

    boolean login(String phone, String password);

    boolean register(String phone, String password);

    /**
     * 判断手机号是否被注册过了
     *
     * @param phone 手机号
     * @return 注册过为 true，否则为 false
     */
    boolean isRegistered(String phone);

    /**
     * 查找用户的角色、权限信息并填入
     *
     * @param user 需要查找的用户
     * @return 填充信息后的用户
     */
    User doGetUserAuthorization(User user);
}
