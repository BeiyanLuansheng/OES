package org.oes.biz.service.impl;

import org.oes.biz.entity.Role;
import org.oes.biz.mapper.RoleMapper;
import org.oes.biz.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author XuJian
 * @since 2021/12/08
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public int createRole(Role role) {
        return roleMapper.insert(role);
    }
}
