package org.oes.common.utils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

/**
 * Base64编码解码
 *
 * @author XuJian
 * @since 2022/01/04
 */
public class Base64Utils {

    public static String encode(String str) {
        return encode(str.getBytes(StandardCharsets.UTF_8));
    }

    public static String encode(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String decode(String str) {
        return Arrays.toString(Base64.getDecoder().decode(str));
    }
}
