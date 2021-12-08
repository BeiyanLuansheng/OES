package org.oes.biz.entity;

/**
 * 角色实体类
 *
 * @author XuJian
 * @since 2021/12/08
 */
public class Role {

    private Long roleId;

    private String roleName;

    private String description;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
