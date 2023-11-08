package com.solo.in.api.feign;

import com.solo.in.api.entity.UniversalTranslation;
import com.solo.in.api.feign.factory.TranslateApiFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(contextId = "translateApi", value = "solo-in", fallback = TranslateApiFallbackFactory.class)
public interface TranslateApi {

    @PostMapping("/in/translate/text")
    String test(@RequestBody UniversalTranslation translation);

}
