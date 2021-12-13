package org.oes.biz.service.impl;

import org.oes.biz.entity.Role;
import org.oes.biz.mapper.RoleMapper;
import org.oes.biz.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author XuJian
 * @since 2021/12/08
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public void createRole(Role role) {
        role.setGmtCreate(new Date());
        role.setGmtModified(new Date());
        roleMapper.insert(role);
    }

    @Override
    public void deleteRoleById(Long roleId) {
        roleMapper.deleteById(roleId);
    }

    @Override
    public void updateRoleById(Role role, boolean fullUpdate) {
        if (fullUpdate) {
            if (role.getGmtModified() == null) {
                role.setGmtModified(new Date());
            }
            roleMapper.fullUpdateById(role);
        } else {
            role.setGmtModified(new Date());
            roleMapper.updateById(role);
        }
    }
}
