package com.solo.common.core.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

public class I18NLocaleResolver implements LocaleResolver {

    /**
     * 解析区域语言环境
     * @param httpServletRequest HTTP Servlet 请求
     * @return {@link Locale}
     */
    @Override
    public @NotNull Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取请求中的语言参数
        String language = httpServletRequest.getHeader("Accept-Encoding");
        //如果没有就使用默认的（根据主机的语言环境生成一个 Locale ）。
        Locale locale = Locale.getDefault();
        //如果请求的链接中携带了 国际化的参数
        if (StringUtils.hasText(language)) {
            //国家，地区
            locale = new Locale(language);
        }
        return locale;
    }

    @Override
    public void setLocale(@NotNull HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }

}