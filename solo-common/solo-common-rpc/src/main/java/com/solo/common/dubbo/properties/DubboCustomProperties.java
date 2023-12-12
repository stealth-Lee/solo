package com.solo.common.dubbo.properties;

import com.solo.common.dubbo.enumd.RequestLogEnum;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * dubbo 自定义配置
 * @author 十一
 * @since 2023/11/29 15:14
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@RefreshScope
@ConfigurationProperties(prefix = "dubbo.custom")
public class DubboCustomProperties {

    private Boolean requestLog;

    private RequestLogEnum logLevel;

}
