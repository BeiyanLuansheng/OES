package org.oes.common.enums;

public enum OrderStatusEnum {

    WAITING("1", "待支付"),
    PAID("2", "已支付"),
    CANCEL("3", "已取消"),
    REVERSE("4", "已退款");

    private final String status;
    private final String desc;

    OrderStatusEnum(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public String getStatus() {
        return this.status;
    }

    public String getDesc() {
        return this.desc;
    }
}
