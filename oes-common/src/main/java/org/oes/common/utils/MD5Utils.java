package org.oes.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * MD5加密密码
 *
 * @author XuJian
 * @since 2021/12/10
 */
public class MD5Utils {

    private static final String ALGORITHM_MD5 = "md5";

    private static final int HASH_ITERATIONS = 5;

    public static String encrypt(String phone, String password) {
        password = StringUtils.lowerCase(password);
        return new SimpleHash(ALGORITHM_MD5, password, ByteSource.Util.bytes(phone), HASH_ITERATIONS).toHex();
    }
}
