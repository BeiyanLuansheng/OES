package org.oes.biz.service.impl;

import org.oes.biz.entity.Role;
import org.oes.biz.mapper.RoleMapper;
import org.oes.biz.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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

    @Override
    public Role findRoleById(Long id) {
        Role role = new Role();
        role.setRoleId(id);
        List<Role> roleList = roleMapper.findRoleList(role);
        return CollectionUtils.isEmpty(roleList) ? null : roleList.get(0);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleMapper.findRoleList(new Role());
    }
}
