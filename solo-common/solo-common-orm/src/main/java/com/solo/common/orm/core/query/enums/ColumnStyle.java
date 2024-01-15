package com.solo.common.orm.core.query.enums;

/**
 * 数据库列风格枚举类
 * @author 十一
 * @since 2023/12/27 13:47
 * 人生若只如初见，何事秋风悲画扇
 **/
public enum ColumnStyle {

    /**
     * 无任何风格，原值返回
     * 例： userName -> userName
     */
    NONE,

    /**
     * 大驼峰风格（帕斯卡式）列
     * 例： userName -> UserName
     */
    PascalCase,

    /**
     * 驼峰下划线风格
     * 例： userName -> user_name
     */
    camel_to_underline

}
