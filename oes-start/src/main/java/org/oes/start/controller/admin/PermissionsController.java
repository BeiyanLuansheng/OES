package org.oes.start.controller.admin;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.oes.biz.entity.Permissions;
import org.oes.biz.service.PermissionsService;
import org.oes.common.constans.ShiroPerms;
import org.oes.common.constans.URIs;
import org.oes.common.entity.OesHttpResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限控制
 *
 * @author XuJian
 * @since 2021/12/13
 */
@RestController
@RequestMapping(URIs.PERMISSIONS)
public class PermissionsController {

    @Resource
    private PermissionsService permissionsService;

    @RequestMapping(method = RequestMethod.GET)
    public OesHttpResponse getPermissions() {
        List<Permissions> allPermissions = permissionsService.getAllPermissions();
        return OesHttpResponse.getSuccess(allPermissions);
    }

    @RequestMapping(method = RequestMethod.POST)
    @RequiresPermissions(ShiroPerms.PERMISSIONS_ADD)
    public OesHttpResponse createPermissions(@RequestBody Permissions permissions) {
        permissionsService.createPermissions(permissions);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @RequiresPermissions(ShiroPerms.PERMISSIONS_DEL)
    public OesHttpResponse deletePermissions(@PathVariable Long id) {
        permissionsService.deletePermissionsById(id);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(method = RequestMethod.PUT)
    @RequiresPermissions(ShiroPerms.PERMISSIONS_UPDATE)
    public OesHttpResponse fullUpdatePermissions(@RequestBody Permissions permissions) {
        permissionsService.updatePermissionsById(permissions, true);
        return OesHttpResponse.getSuccess();
    }

    @RequestMapping(method = RequestMethod.PATCH)
    @RequiresPermissions(ShiroPerms.PERMISSIONS_UPDATE)
    public OesHttpResponse updatePermissions(@RequestBody Permissions permissions) {
        permissionsService.updatePermissionsById(permissions, false);
        return OesHttpResponse.getSuccess();
    }
}
