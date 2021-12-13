package org.oes.biz.service.impl;

import org.oes.biz.entity.Permissions;
import org.oes.biz.mapper.PermissionsMapper;
import org.oes.biz.service.PermissionsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author XuJian
 * @since 2021/12/08
 */
@Service
public class PermissionsImpl implements PermissionsService {

    @Resource
    private PermissionsMapper permissionsMapper;

    @Override
    public void createPermissions(Permissions permissions) {
        permissions.setGmtCreate(new Date());
        permissions.setGmtModified(new Date());
        permissionsMapper.insert(permissions);
    }

    @Override
    public void deletePermissionsById(Long id) {
        permissionsMapper.deleteById(id);
    }

    @Override
    public void updatePermissionsById(Permissions permissions, boolean fullUpdate) {
        if (fullUpdate) {
            permissionsMapper.fullUpdateById(permissions);
        } else {
            permissionsMapper.updateById(permissions);
        }
    }
}
