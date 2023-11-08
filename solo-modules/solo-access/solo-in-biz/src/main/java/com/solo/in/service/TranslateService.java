package com.solo.in.service;

import com.solo.in.api.entity.UniversalTranslation;

/**
 * 三方翻译Service
 * @author 十一
 * @since 2023/11/06 09:45
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface TranslateService {

    String text(UniversalTranslation translation);

}
