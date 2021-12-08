package org.oes.biz.mapper;

import org.apache.ibatis.annotations.Param;
import org.oes.biz.entity.Role;

/**
 * @author XuJian
 * @since 2021/12/08
 */
public interface RoleMapper {

    int insert(@Param("role") Role role);
}
