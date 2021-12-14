package org.oes.common.enums;

/**
 * 系统中的基础角色
 *
 * @author XuJian
 * @since 2021/12/09
 */
public enum RoleEnum {

    STUDENT(1L, "学生"),
    TEACHER(2L, "教师"),
    ADMINISTRATOR(3L, "管理员");

    private final Long id;
    private final String desc;

    RoleEnum(Long id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public Long getCode() {
        return id;
    }

    public String getDesc() {
        return desc;
    }
}
