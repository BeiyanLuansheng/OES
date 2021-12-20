package org.oes.biz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色实体类
 *
 * @author XuJian
 * @since 2021/12/08
 */
public class Role implements Serializable {

    private static final long serialVersionUID = -1510190218566290276L;

    /**
     * 角色唯一 ID
     */
    private Long roleId;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 角色信息创建时间
     */
    private Date gmtCreate;

    /**
     * 角色信息修改时间
     */
    private Date gmtModified;

    /**
     * 用于传递查询条件
     */
    private Date gmtCreateFrom;
    private Date gmtCreateTo;
    private Date gmtModifiedFrom;
    private Date gmtModifiedTo;

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

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtCreateFrom() {
        return gmtCreateFrom;
    }

    public void setGmtCreateFrom(Date gmtCreateFrom) {
        this.gmtCreateFrom = gmtCreateFrom;
    }

    public Date getGmtCreateTo() {
        return gmtCreateTo;
    }

    public void setGmtCreateTo(Date gmtCreateTo) {
        this.gmtCreateTo = gmtCreateTo;
    }

    public Date getGmtModifiedFrom() {
        return gmtModifiedFrom;
    }

    public void setGmtModifiedFrom(Date gmtModifiedFrom) {
        this.gmtModifiedFrom = gmtModifiedFrom;
    }

    public Date getGmtModifiedTo() {
        return gmtModifiedTo;
    }

    public void setGmtModifiedTo(Date gmtModifiedTo) {
        this.gmtModifiedTo = gmtModifiedTo;
    }
}
