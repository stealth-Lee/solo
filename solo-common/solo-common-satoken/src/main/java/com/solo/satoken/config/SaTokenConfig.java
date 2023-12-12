package com.solo.satoken.config;

import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpLogic;
import com.solo.satoken.service.SaPermissionImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * Sa-Token 配置类
 * @author 十一
 * @since 2023/11/30 11:38
 * 人生若只如初见，何事秋风悲画扇
 **/
@AutoConfiguration
@PropertySource(value = "classpath:common-satoken.yml", factory = org.dromara.common.core.factory.YmlPropertySourceFactory.class)
public class SaTokenConfig {

    /**
     * Sa-Token 整合 jwt (Simple 简单模式)
     */
    @Bean
    public StpLogic getStpLogicJwt() {
        return new StpLogicJwtForSimple();
    }

    /**
     * 权限接口实现(使用bean注入方便用户替换)
     */
    @Bean
    public StpInterface stpInterface() {
        return new SaPermissionImpl();
    }

}