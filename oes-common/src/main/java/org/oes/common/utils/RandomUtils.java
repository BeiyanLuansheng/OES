package org.oes.common.utils;

import java.util.Random;

/**
 * 随机数工具
 * @author XuJian
 * @since 2021/12/27
 */
public class RandomUtils {

    /**
     * 生成指定范围内的整数
     *
     * @param origin 起始（包含）
     * @param bound 结束（不包含）
     * @return 范围内的整数
     */
    public static int randomInt(int origin, int bound) {
        Random random = new Random();
        return random.nextInt(bound - origin) + origin;
    }
}
