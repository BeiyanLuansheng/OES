package org.oes.biz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色权限实体类
 *
 * @author XuJian
 * @since 2021/12/08
 */
public class RolePermissions implements Serializable {

    private static final long serialVersionUID = -1164040840556475540L;

    /**
     * 角色 ID，依赖 Role
     */
    private Long roleId;

    /**
     * 权限 ID，依赖 Permissions
     */
    private Long permissionsId;

    /**
     * 授权时间
     */
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
