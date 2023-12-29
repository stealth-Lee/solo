package com.solo.common.core.base.consts;

import com.solo.common.core.utils.MessageUtils;

/**
 * 错误代码接口
 * @author 十一
 * @since 2023/09/11 17:14
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface BasicCode {

    /**
     * 错误码
     */
    Integer code();

    /**
     * i18n资源文件的key
     */
    String i18nKey();

    /**
     * i18n资源文件的value
     */
    default String message() {
        return MessageUtils.getMessage(i18nKey());
    }

}
