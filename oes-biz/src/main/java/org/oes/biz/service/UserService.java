package org.oes.biz.service;

import org.oes.biz.entity.User;

/**
 * @author XuJian
 * @since 2021/12/08
 */
public interface UserService {

    /**
     * 创建用户信息记录
     *
     * @param user 用户信息
     * @return 创建数量
     */
    int createUser(User user);

    /**
     * 获取用户信息
     * @param userId 用户ID
     * @return 用户信息
     */
    User getById(Long userId);

    /**
     * 根据ID更新用户信息
     *
     * @param user 待更新信息
     */
    void updateById(User user);

    /**
     * 更新密码
     *
     * @param email 邮箱
     * @param password 变动后的密码 (未加密)
     */
    void updatePassword(String email, String password);

    /**
     * 根据Email更新头像
     *
     * @param email 邮箱
     * @param avatar 头像链接
     */
    void updateAvatar(String email, String avatar);

    /**
     * 根据手机号查找用户
     *
     * @param phone 手机号
     * @return 不存在则为空
     */
    User findByPhone(String phone);

    /**
     * 根据邮箱查找用户
     *
     * @param email 又邮箱
     * @return 不存在则为空
     */
    User findByEmail(String email);

    /**
     * 判断手机号是否被注册过了
     *
     * @param phone 手机号
     * @return 注册过为 true，否则为 false
     */
    boolean isPhoneRegistered(String phone);

    /**
     * 判断邮箱是否被注册过了
     *
     * @param email 邮箱
     * @return 注册过为 true，否则为 false
     */
    boolean isEmailRegistered(String email);

    /**
     * 使用默认密码注册
     *
     * @param email 邮箱
     */
    void register(String email);

    /**
     * 使用默认密码注册
     *
     * @param email 邮箱
     * @param password 密码
     */
    void register(String email, String password);

    /**
     * 查找用户的角色、权限信息并填入
     *
     * @param user 需要查找的用户
     * @return 填充信息后的用户
     */
    User doGetUserAuthorization(User user);
}
