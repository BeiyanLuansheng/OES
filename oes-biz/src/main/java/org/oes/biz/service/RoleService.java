package org.oes.biz.service;

import org.oes.biz.entity.Role;

import java.util.List;

/**
 * @author XuJian
 * @since 2021/12/08
 */
public interface RoleService {

    /**
     * 创建新角色
     * @param role 角色信息
     */
    void createRole(Role role);

    /**
     * 删除角色
     * @param id 角色 ID
     */
    void deleteRoleById(Long id);

    /**
     * 根据 ID 更新角色信息
     * @param role 角色信息
     * @param fullUpdate true 全量更新，false 增量更新
     */
    void updateRoleById(Role role, boolean fullUpdate);

    /**
     * 根据 ID 查找角色
     * @param id 角色ID
     * @return 角色信息
     */
    Role findRoleById(Long id);

    /**
     * 所有角色列表
     * @return 所有角色列表
     */
    List<Role> getAllRoles();
}
