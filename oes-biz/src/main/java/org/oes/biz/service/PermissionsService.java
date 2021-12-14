package org.oes.biz.service;

import org.oes.biz.entity.Permissions;

import java.util.List;

/**
 * @author XuJian
 * @since 2021/12/08
 */
public interface PermissionsService {

    /**
     * 新建权限
     *
     * @param permissions 权限
     */
    void createPermissions(Permissions permissions);

    /**
     * 删除权限
     *
     * @param id 权限 ID
     */
    void deletePermissionsById(Long id);

    /**
     * 更新权限信息
     *
     * @param permissions 权限信息
     * @param fullUpdate 全量更新/增量更新
     */
    void updatePermissionsById(Permissions permissions, boolean fullUpdate);

    /**
     * 根据角色 ID 查找角色的权限
     *
     * @param roleId ID
     * @return 角色权限列表
     */
    List<Permissions> findRolePermissions(Long roleId);
}
