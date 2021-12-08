package org.oes.biz.entity;

/**
 * 角色权限实体类
 *
 * @author XuJian
 * @since 2021/12/08
 */
public class RolePermissions {

    private Long roleId;

    private Long permissionsId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionsId() {
        return permissionsId;
    }

    public void setPermissionsId(Long permissionsId) {
        this.permissionsId = permissionsId;
    }
}
