package com.solo.common.core.constant;

/**
 * 错误代码接口
 * @author Gentleman.Lee
 * @since 2023/09/11 17:14
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface ErrorCode {

    /**
     * 错误码
     */
    Integer code();

    /**
     * 消息提示
     */
    String message();

    /**
     * i18n资源文件的key TODO 未实现
     */
    String i18nKey();

}
