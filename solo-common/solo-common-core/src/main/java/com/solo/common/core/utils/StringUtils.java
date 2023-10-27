package com.solo.common.core.utils;

import cn.hutool.core.util.StrUtil;

/**
 * 字符串工具类
 * @author 十一
 * @since 2023/09/12 15:31
 * 人生若只如初见，何事秋风悲画扇
 **/
public class StringUtils extends StrUtil {

    /**
     * 去掉首部指定长度的字符串并将剩余字符串首字母大写
     * @param str 字符串
     * @param preLength 去掉的长度
     * @return 处理后的字符串
     */
    public static String removePreAndUpperFirst(CharSequence str, int preLength) {
        if (str == null) {
            return null;
        }
        if (str.length() > preLength) {
            char first = Character.toUpperCase(str.charAt(preLength));
            if (str.length() > preLength + 1) {
                return first + str.toString().substring(preLength + 1);
            }
            return String.valueOf(first);
        } else {
            return str.toString();
        }
    }

    /**
     * 去掉首部指定字符前的字符串并将剩余字符串首字母大写
     * @param str 字符串
     * @param separator 指定字符
     * @return 处理后的字符串
     */
    public static String removePreAndUpperFirst(CharSequence str, char separator) {
        return removePreAndUpperFirst(str, indexOf(str, separator) + 1);
    }

    public static void main(String[] args) {
//        System.out.println(removePreAndUpperFirst("system_user", '_'));
//        System.out.println(toUnderlineCase("systemUseraA"));
//        String  a  = "130603195301131228";
//        System.out.println(a.substring(0,6) + a.substring(8, 17));
//        System.out.println(split("sys_user_role", '_', 2));
//        System.out.println(replace("sys_user_role", "_", "-"));
        System.out.println(subAfter("java.long.String", ".", true));
    }

}
