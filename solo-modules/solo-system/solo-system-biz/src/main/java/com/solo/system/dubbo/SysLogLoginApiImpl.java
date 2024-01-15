package com.solo.system.dubbo;

import com.solo.system.api.SysLogLoginApi;
import com.solo.system.api.entity.SysLogLogin;
import com.solo.system.mapper.SysLogLoginMapper;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * 登录日志api实现类
 * @author 十一
 * @since 2024/01/02 15:50
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
@DubboService
public class SysLogLoginApiImpl implements SysLogLoginApi {

    @Resource
    private SysLogLoginMapper sysLoginLogMapper;

    @Override
    public int save(SysLogLogin entity) {
        return sysLoginLogMapper.insert(entity, true);
    }

}
