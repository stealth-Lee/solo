package com.solo.in.web;

import com.solo.in.api.entity.UniversalTranslation;
import com.solo.in.service.TranslateService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 三方翻译控制器
 * @author 十一
 * @since 2023/11/06 09:44
 * 人生若只如初见，何事秋风悲画扇
 **/
@RestController
@RequestMapping("/in/translate")
public class TranslateController {

    @Resource
    private TranslateService translateService;

    /**
     * 文本翻译
     * @param translation
     * @return
     */
    @PostMapping("/text")
    public String text(@RequestBody UniversalTranslation translation) {
        return translateService.text(translation);
    }

}
