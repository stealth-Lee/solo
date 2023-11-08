package com.solo.in.api.feign.factory;

import com.solo.in.api.entity.UniversalTranslation;
import com.solo.in.api.feign.TranslateApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

@Slf4j
public class TranslateApiFallbackFactory  implements FallbackFactory<TranslateApi> {
    @Override
    public TranslateApi create(Throwable cause) {
        log.error("百度翻译服务调用失败:{}", cause.getMessage());
        return new TranslateApi() {
            @Override
            public String test(UniversalTranslation translation) {
                return null;
            }
        };
    }
}
