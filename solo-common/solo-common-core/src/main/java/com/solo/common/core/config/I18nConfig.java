package com.solo.common.core.config;

import com.solo.common.core.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * 字段校验国际化配置
 * @author Gentleman.Lee
 * @since 2023/12/20 15:05
 * 人生若只如初见，何事秋风悲画扇
 **/
@Slf4j
@AutoConfiguration
public class I18nConfig {

    /**
     * 因为 spring.messages.basename 不支持通配符, 所以需要动态加载多个业务模块的国际化文件
     * 严格遵守 i18n/{module}/message 的命名规范
     * @return {@link MessageSource}
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            org.springframework.core.io.Resource[] resources = resolver.getResources("classpath*:i18n/**");
            for (Resource resource : resources) {
                if (resource.getFile().isDirectory()) {
                    String uri = resource.getURI().toString();
                    String module = StringUtils.subAfter(uri, "/i18n/", false);
                    String path = "classpath:i18n/" + module + "message";
                    messageSource.addBasenames(path);
                    log.info("i18n 国际化文件加载成功: {}", path);
                }
            }
            // 默认加载全局的国际化文件
            messageSource.addBasenames("classpath:i18n/message");
        } catch (IOException e) {
            // Handle the exception
        }
        return messageSource;
    }

    /**
     * 获取LocaleResolver
     * @return
     */
//    @Bean
//    public LocaleResolver localeResolver() {
//        return new I18NLocaleResolver();
//    }

}
