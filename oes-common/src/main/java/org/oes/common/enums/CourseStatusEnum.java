package org.oes.common.enums;

public enum CourseStatusEnum {
    NEW_CREATE("1", "新创建"),
    WAITING_FOR_AUDIT("2", "审核中"),
    AUDIT_PASS("3", "审核通过"),
    ONGOING("4", "课程进行中"),
    FINISHED("5", "课程结束");

    private final String code;
    private final String desc;

    CourseStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static CourseStatusEnum getStatusByCode(String code) {
        for (CourseStatusEnum status: CourseStatusEnum.values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return null;
    }

}
