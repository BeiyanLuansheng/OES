package org.oes.gateway.controller;

import org.oes.biz.entity.Role;
import org.oes.biz.entity.RolePermissions;
import org.oes.biz.service.RolePermissionsService;
import org.oes.biz.service.RoleService;
import org.oes.common.constans.URIConstant;
import org.oes.common.entity.OesHttpResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 角色控制，包括角色拥有的权限控制
 *
 * @author XuJian
 * @since 2021/12/13
 */
@RestController
@RequestMapping(URIConstant.ROLE)
public class RoleController {

    @Resource
    private RoleService roleService;
    @Resource
    private RolePermissionsService rolePermissionsService;

    @RequestMapping(method = RequestMethod.POST)
    public OesHttpResponse createRole(@RequestBody Role role) {
        roleService.createRole(role);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public OesHttpResponse deleteRole(@PathVariable Long id) {
        roleService.deleteRoleById(id);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public OesHttpResponse fullUpdateRole(@RequestBody Role role) {
        roleService.updateRoleById(role, true);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public OesHttpResponse updateRole(@RequestBody Role role) {
        roleService.updateRoleById(role, false);
        return OesHttpResponse.getSuccess();
    }

    /* =========================== 角色权限设置 =============================== */

    @RequestMapping(value = URIConstant.PERMISSIONS, method = RequestMethod.POST)
    public OesHttpResponse addPermissions(@RequestBody RolePermissions rolePermissions) {
        rolePermissionsService.createRolePermissions(rolePermissions);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(value = URIConstant.PERMISSIONS, method = RequestMethod.DELETE)
    public OesHttpResponse removePermissions(@RequestBody RolePermissions rolePermissions) {
        rolePermissionsService.removeRolePermissions(rolePermissions);
        return OesHttpResponse.getSuccess();
    }
}
