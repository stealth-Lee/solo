package com.solo.in.api;

import com.solo.in.api.entity.UniversalTranslation;

/**
 * 翻译Api
 * @author Gentleman.Lee
 * @since 2023/12/14 09:25
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface TranslateApi {

    /**
     * 文本翻译
     * @param translation 译本
     * @return {@link String}
     */
    String text(UniversalTranslation translation);

}
