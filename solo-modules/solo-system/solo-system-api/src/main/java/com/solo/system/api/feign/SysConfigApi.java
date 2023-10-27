package com.solo.system.api.feign;

import com.solo.common.core.global.R;
import com.solo.system.api.entity.SysConfig;
import com.solo.system.api.feign.factory.SysConfigApiFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(contextId = "sysConfigApi", value = "solo-system", fallback = SysConfigApiFallbackFactory.class)
public interface SysConfigApi {

    @GetMapping("/system/config/key/{configKey}")
    R<SysConfig> selectConfigByKey(@PathVariable(value = "configKey") String configKey);

}
