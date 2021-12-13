package org.oes.biz.mapper;

import org.apache.ibatis.annotations.Param;
import org.oes.biz.entity.Permissions;

/**
 * @author XuJian
 * @since 2021/12/08
 */
public interface PermissionsMapper {

    /**
     * 新建权限
     *
     * @param permissions 新权限
     * @return 影响行数
     */
    int insert(@Param("perms") Permissions permissions);

    /**
     * 根据 ID 删除权限
     *
     * @param permissionsId 权限 ID
     * @return 影响行数
     */
    int deleteById(Long permissionsId);

    /**
     * 根据 ID 增量更新权限
     *
     * @param permissions 权限信息
     * @return 影响行数
     */
    int fullUpdateById(@Param("perms") Permissions permissions);

    /**
     * 根据 ID 全量更新权限
     *
     * @param permissions 权限信息
     * @return 影响行数
     */
    int updateById(@Param("perms") Permissions permissions);
}
