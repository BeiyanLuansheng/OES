package org.oes.biz.mapper;

import org.apache.ibatis.annotations.Param;
import org.oes.biz.entity.Role;

import java.util.List;

/**
 * @author XuJian
 * @since 2021/12/08
 */
public interface RoleMapper {

    /**
     * 新建角色
     *
     * @param role 角色信息
     * @return 影响行数 n （n>=1，n为0时插入失败）
     */
    int insert(@Param("role") Role role);

    /**
     * 根据 ID 删除角色
     *
     * @param roleId 角色 ID
     * @return 影响行数
     */
    int deleteById(Long roleId);

    /**
     * 根据 ID 增量更新角色信息
     *
     * @param role 角色信息
     * @return 影响行数
     */
    int updateById(@Param("role") Role role);

    /**
     * 根据 ID 全量更新角色信息
     *
     * @param role 角色信息
     * @return 影响行数
     */
    int fullUpdateById(@Param("role") Role role);

    /**
     * 根据条件查找满足条件的角色
     *
     * @param role 条件
     * @return 角色列表
     */
    List<Role> findRoleList(@Param("role") Role role);
}
