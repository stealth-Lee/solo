package com.solo.common.dubbo.config;

import com.solo.common.dubbo.properties.DubboCustomProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * dubbo 配置类
 * @author 十一
 * @since 2023/11/29 15:09
 * 人生若只如初见，何事秋风悲画扇
 **/
@AutoConfiguration
@EnableConfigurationProperties(DubboCustomProperties.class)
@PropertySource(value = "classpath:common-dubbo.yml", factory = org.dromara.common.core.factory.YmlPropertySourceFactory.class)
public class DubboConfig {

}
