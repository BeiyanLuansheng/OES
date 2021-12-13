package org.oes.biz.service.impl;

import org.oes.biz.entity.RolePermissions;
import org.oes.biz.mapper.RolePermissionsMapper;
import org.oes.biz.service.RolePermissionsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author XuJian
 * @since 2021/12/08
 */
@Service
public class RolePermissionsServiceImpl implements RolePermissionsService {

    @Resource
    private RolePermissionsMapper rolePermissionsMapper;

    @Override
    public void createRolePermissions(RolePermissions rolePermissions) {
        rolePermissions.setGmtCreate(new Date());
        rolePermissionsMapper.insert(rolePermissions);
    }

    @Override
    public void removeRolePermissions(RolePermissions rolePermissions) {
        rolePermissionsMapper.delete(rolePermissions);
    }
}
