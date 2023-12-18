package com.solo.system.dubbo;

import com.solo.system.api.SysOperateLogApi;
import com.solo.system.api.entity.SysOperateLog;
import com.solo.system.mapper.SysOperateLogMapper;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * 操作日志api实现类
 * @author Gentleman.Lee
 * @since 2023/12/15 10:41
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
@DubboService
public class SysOperateLogApiImpl implements SysOperateLogApi {

    @Resource
    private SysOperateLogMapper sysOperateLogMapper;

    @Override
    public int save(SysOperateLog entity) {
        return sysOperateLogMapper.insert(entity);
    }

}
