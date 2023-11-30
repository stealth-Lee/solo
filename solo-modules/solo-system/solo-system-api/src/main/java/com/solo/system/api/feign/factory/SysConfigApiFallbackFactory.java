package com.solo.system.api.feign.factory;

import com.solo.common.core.global.R;
import com.solo.system.api.entity.SysDictData;
import com.solo.system.api.feign.SysDictApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class SysConfigApiFallbackFactory implements FallbackFactory<SysDictApi> {
    @Override
    public SysDictApi create(Throwable cause) {
        log.error("系统参数服务调用失败:{}", cause.getMessage());
        return new SysDictApi() {
            @Override
            public R<List<SysDictData>> selectByCode(String code) {
                return null;
            }
        };
    }
}