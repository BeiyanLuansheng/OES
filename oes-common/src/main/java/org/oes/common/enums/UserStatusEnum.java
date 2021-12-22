package org.oes.common.enums;

public enum UserStatusEnum {

    LOCK("0", "锁定"),
    VALID("1", "有效"),
    WAITING_FOR_VERIFICATION("2", "等待验证手机验证码"),
    WAITING_FOR_PASSWORD("3", "等待更新密码");

    private final String code;
    private final String desc;

    UserStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
