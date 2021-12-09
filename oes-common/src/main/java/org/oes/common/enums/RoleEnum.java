package org.oes.common.enums;

/**
 * 系统中的基础角色
 *
 * @author XuJian
 * @since 2021/12/09
 */
public enum RoleEnum {

    STUDENT(1L, "学生角色"),
    TEACHER(2L, "教师角色"),
    ADMINISTRATOR(3L, "管理员角色");

    private final Long code;
    private final String desc;

    RoleEnum(Long code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Long getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
