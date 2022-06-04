package org.oes.common.constans;

/**
 * Shiro 管理的权限，与数据库同步
 * @author XuJian
 * @since 2021/12/27
 */
public interface ShiroPerms {

    // 权限管理
    String PERMISSIONS_ADD =  "permissions:add";
    String PERMISSIONS_DEL =  "permissions:delete";
    String PERMISSIONS_UPDATE =  "permissions:update";

    // 角色管理
    String ROLE_ADD =  "role:add";
    String ROLE_DEL =  "role:delete";
    String ROLE_UPDATE =  "role:update";

    // 角色权限管理
    String ROLE_PERMS_ADD = "role:perms:add";
    String ROLE_PERMS_DEL = "role:perms:remove";

    // 课程信息管理
    String COURSE_ADD = "course:add";
    String COURSE_UPDATE = "course:update";

    // 首页轮播
    String BANNER_ADD = "banner:add";
    String BANNER_UPDATE = "banner:update";
    String BANNER_DEL = "banner:delete";

    // 类目管理
    String CATEGORY_ADD = "category:add";
    String CATEGORY_DEL = "category:delete";
}
