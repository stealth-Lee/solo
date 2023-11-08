package com.solo.system.api.feign;

import com.solo.common.core.global.R;
import com.solo.system.api.entity.SysDictData;
import com.solo.system.api.feign.factory.SysDictApiFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(contextId = "sysDictApi", value = "solo-system", fallback = SysDictApiFallbackFactory.class)
public interface SysDictApi {

    @GetMapping("/system/dict-data/code/{code}")
    R<List<SysDictData>> selectByCode(@PathVariable("code") String code);

}
