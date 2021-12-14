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
     * 查找用户的角色、权限信息并填入
     *
     * @param user 需要查找的用户
     * @return 填充信息后的用户
     */
    User doGetUserAuthorization(User user);
}
