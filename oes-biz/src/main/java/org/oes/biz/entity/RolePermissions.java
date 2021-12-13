package org.oes.biz.entity;

import java.util.Date;

/**
 * 角色权限实体类
 *
 * @author XuJian
 * @since 2021/12/08
 */
public class RolePermissions {

    private Long roleId;

    private Long permissionsId;

    private Date gmtCreate;

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

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}
