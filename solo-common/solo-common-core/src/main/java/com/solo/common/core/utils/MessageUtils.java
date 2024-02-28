package com.solo.common.core.utils;

import cn.hutool.extra.spring.SpringUtil;
import lombok.experimental.UtilityClass;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * 国际化支持工具类
 */
@UtilityClass
public class MessageUtils {

    private static final MessageSource messageSource = SpringUtil.getBean(MessageSource.class);

    /**
     * 获取国际化消息
     * @param code 消息编码
     * @return 国际化消息
     */
    public static String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

    public static String getMessage(String code, Object... arg) {
        return messageSource.getMessage(code, arg, LocaleContextHolder.getLocale());
    }

//    public static String getI18NMessage(MessagesEnum messagesEnum) {
//        return getI18NMessage(messagesEnum.getCode(), messagesEnum.getMsg());
//    }

}
