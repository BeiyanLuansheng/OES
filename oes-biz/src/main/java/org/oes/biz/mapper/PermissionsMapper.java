package org.oes.biz.mapper;

import org.apache.ibatis.annotations.Param;
import org.oes.biz.entity.Permissions;

/**
 * @author XuJian
 * @since 2021/12/08
 */
public interface PermissionsMapper {

    int insert(@Param("permissions") Permissions permissions);
}
