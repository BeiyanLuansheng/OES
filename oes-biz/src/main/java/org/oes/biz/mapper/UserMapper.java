package org.oes.biz.mapper;

import org.apache.ibatis.annotations.Param;
import org.oes.biz.entity.User;

/**
 * @author XuJian
 * @since 2021/12/08
 */
public interface UserMapper {

    int insert(@Param("user") User user);

    void updateByEmail(@Param("user") User user);

    User findByPhone(@Param("phone") String phone);

    User findByEmail(@Param("email") String email);
}
