package org.oes.biz.mapper;

import org.apache.ibatis.annotations.Param;
import org.oes.biz.entity.RolePermissions;

/**
 * @author XuJian
 * @since 2021/12/08
 */
public interface RolePermissionsMapper {

    int insert(@Param("rolePerms") RolePermissions rolePermissions);

    int delete(@Param("rolePerms") RolePermissions rolePermissions);
}
