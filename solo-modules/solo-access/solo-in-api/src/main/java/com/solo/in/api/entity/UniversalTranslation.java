package com.solo.in.api.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 通用翻译实体类
 * @author 十一
 * @since 2023/12/11 17:28
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class UniversalTranslation implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

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
