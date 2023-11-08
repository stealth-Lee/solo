package com.solo.in.api.entity;

import lombok.Data;

@Data
public class UniversalTranslation {

    /**
     * 翻译源语言,可设置为auto
     */
    private String from;

    /**
     * 翻译目标语言,不可设置为auto
     */
    private String to;

    /**
     * 请求翻译query,UTF-8编码
     */
    private String q;

    /**
     * APPID,可在管理控制台查看
     */
    private String appid;

    /**
     * 随机数,可为字母或数字的字符串
     */
    private String salt;

    /**
     * 签名
     */
    private String sign;

}
