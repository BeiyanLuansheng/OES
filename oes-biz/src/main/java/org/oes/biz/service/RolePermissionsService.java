package org.oes.biz.service;

import org.oes.biz.entity.RolePermissions;

/**
 * @author XuJian
 * @since 2021/12/08
 */
public interface RolePermissionsService {

    void createRolePermissions(RolePermissions rolePermissions);

    void removeRolePermissions(RolePermissions rolePermissions);
}
