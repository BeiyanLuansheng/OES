package org.oes.start.controller.admin;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.oes.biz.entity.Permissions;
import org.oes.biz.entity.Role;
import org.oes.biz.entity.RolePermissions;
import org.oes.biz.service.PermissionsService;
import org.oes.biz.service.RolePermissionsService;
import org.oes.biz.service.RoleService;
import org.oes.common.constans.ShiroPerms;
import org.oes.common.constans.URIs;
import org.oes.common.entity.OesHttpResponse;
import org.oes.start.controller.BaseController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色控制，包括角色拥有的权限控制
 *
 * @author XuJian
 * @since 2021/12/13
 */
@RestController
@RequestMapping(URIs.ROLE)
public class RoleController extends BaseController {

    @Resource
    private RoleService roleService;
    @Resource
    private RolePermissionsService rolePermissionsService;
    @Resource
    private PermissionsService permissionsService;

    @RequestMapping(method = RequestMethod.GET)
    public OesHttpResponse getAllRoles() {
        List<Role> allRoles = roleService.getAllRoles();
        return OesHttpResponse.getSuccess(allRoles);
    }

    @RequestMapping(method = RequestMethod.POST)
    @RequiresPermissions(ShiroPerms.ROLE_ADD)
    public OesHttpResponse createRole(@RequestBody Role role) {
        roleService.createRole(role);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @RequiresPermissions(ShiroPerms.ROLE_DEL)
    public OesHttpResponse deleteRole(@PathVariable Long id) {
        roleService.deleteRoleById(id);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(method = RequestMethod.PUT)
    @RequiresPermissions(ShiroPerms.ROLE_UPDATE)
    public OesHttpResponse fullUpdateRole(@RequestBody Role role) {
        roleService.updateRoleById(role, true);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(method = RequestMethod.PATCH)
    @RequiresPermissions(ShiroPerms.ROLE_UPDATE)
    public OesHttpResponse updateRole(@RequestBody Role role) {
        roleService.updateRoleById(role, false);
        return OesHttpResponse.getSuccess();
    }

    /* =========================== 角色权限设置 =============================== */
    @RequestMapping(value = URIs.PERMISSIONS, method = RequestMethod.GET)
    public OesHttpResponse getPermissions(@RequestBody RolePermissions rolePermissions) {
        List<Permissions> permissionsList = permissionsService.findRolePermissions(rolePermissions.getRoleId());
        return OesHttpResponse.getSuccess(permissionsList);
    }

    @RequestMapping(value = URIs.PERMISSIONS, method = RequestMethod.POST)
    @RequiresPermissions(ShiroPerms.ROLE_PERMS_ADD)
    public OesHttpResponse addPermissions(@RequestBody RolePermissions rolePermissions) {
        rolePermissionsService.createRolePermissions(rolePermissions);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(value = URIs.PERMISSIONS, method = RequestMethod.DELETE)
    @RequiresPermissions(ShiroPerms.ROLE_PERMS_DEL)
    public OesHttpResponse removePermissions(@RequestBody RolePermissions rolePermissions) {
        rolePermissionsService.removeRolePermissions(rolePermissions);
        return OesHttpResponse.getSuccess();
    }
}
