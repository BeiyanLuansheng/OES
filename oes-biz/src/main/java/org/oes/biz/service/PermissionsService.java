package org.oes.biz.service;

import org.oes.biz.entity.Permissions;

/**
 * @author XuJian
 * @since 2021/12/08
 */
public interface PermissionsService {

    void createPermissions(Permissions permissions);

    void deletePermissionsById(Long id);

    void updatePermissionsById(Permissions permissions, boolean fullUpdate);
}
