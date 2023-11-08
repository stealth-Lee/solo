package com.solo.common.core.utils;

import cn.hutool.core.util.StrUtil;

import java.util.regex.Pattern;

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

    /**
     * 判断是否是英文
     * @param str 字符串
     * @return 是否是英文
     */
    public static boolean isEnglish(String str) {
        String pattern = ".*[a-zA-Z].*";
        return Pattern.matches(pattern, str);
    }

    /**
     * 大写英文单词首字母
     * 例如：hello word -> Hello World； hello i18n -> Hello i18n
     * @param input 源文本
     * @return 大写后的字符串
     */
    public static String capitalizeEnglishWords(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        String[] words = input.split("\\s+");
        StringBuilder result = new StringBuilder();
        Pattern englishWordPattern = Pattern.compile("^[a-z]+$");
        for (String word : words) {
            if (englishWordPattern.matcher(word).matches()) {
                if (!word.isEmpty()) {
                    result.append(Character.toUpperCase(word.charAt(0)));
                    if (word.length() > 1) {
                        result.append(word.substring(1));
                    }
                }
            } else {
                result.append(word); // 不是英文单词，保持原样
            }
            result.append(" ");
        }
        if (!result.isEmpty()) {
            result.setLength(result.length() - 1); // 移除末尾的额外空格
        }
        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(isEnglish("hello, 啊 1213"));
    }

}
