package org.oes.biz.service.impl;

import org.oes.biz.entity.Permissions;
import org.oes.biz.mapper.PermissionsMapper;
import org.oes.biz.service.PermissionsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author XuJian
 * @since 2021/12/08
 */
@Service
public class PermissionsImpl implements PermissionsService {

    @Resource
    private PermissionsMapper permissionsMapper;

    @Override
    public int createPermissions(Permissions permissions) {
        return permissionsMapper.insert(permissions);
    }
}
