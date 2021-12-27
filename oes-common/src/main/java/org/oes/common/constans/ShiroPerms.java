package org.oes.common.constans;

/**
 * Shiro 管理的权限，与数据库同步
 * @author XuJian
 * @since 2021/12/27
 */
public interface ShiroPerms {

    String PERMISSIONS_ADD =  "permissions:add";
    String PERMISSIONS_DEL =  "permissions:delete";
    String PERMISSIONS_UPDATE =  "permissions:update";

    String ROLE_ADD =  "role:add";
    String ROLE_DEL =  "role:delete";
    String ROLE_UPDATE =  "role:update";

    String ROLE_PERMS_ADD = "role:perms:add";
    String ROLE_PERMS_DEL = "role:perms:remove";
}
