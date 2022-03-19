package org.oes.common.enums;

/**
 * @author XuJian
 * @since 2022/03/19
 */
public enum FileTypeEnum {

    VIDEO("video"),
    PICTURE("pic"),
    DOCUMENT("doc"),
    OTHER("other");

    private final String type;

    public String getType() {
        return type;
    }

    FileTypeEnum(String type) {
        this.type = type;
    }
}
