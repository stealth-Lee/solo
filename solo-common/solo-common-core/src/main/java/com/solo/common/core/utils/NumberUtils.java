package com.solo.common.core.utils;

import cn.hutool.core.util.NumberUtil;

/**
 * 数字工具类
 * @author 十一
 * @since 2023/09/12 15:34
 * 人生若只如初见，何事秋风悲画扇
 **/
public class NumberUtils extends NumberUtil {

    /**
     * 判断是否是正整数
     * @param value 数字
     * @return 否是正整数
     */
    public static boolean isPositiveInteger(short value) {
        return value > 0;
    }

    /**
     * 判断是否是正整数
     * @param value 数字
     * @return 否是正整数
     */
    public static boolean isPositiveInteger(int value) {
        return value > 0;
    }

    /**
     * 判断是否是正整数
     * @param value 数字
     * @return 否是正整数
     */
    public static boolean isPositiveInteger(long value) {
        return value > 0;
    }

}
