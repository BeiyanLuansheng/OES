package org.oes.common.utils;

/**
 * @author XuJian
 * @since 2021/12/09
 */
public class StringUtils {

    public static boolean isBlank(String str) {
        return  str == null || str.length() == 0;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean equals(String a, String b) {
        if (isBlank(a) && isBlank(b)) {
            return true;
        }
        if (isNotBlank(a)) {
            return a.equals(b);
        } else {
            return b.equals(a);
        }
    }
}
