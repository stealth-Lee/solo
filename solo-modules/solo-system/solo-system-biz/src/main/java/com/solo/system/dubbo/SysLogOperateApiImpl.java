package com.solo.system.dubbo;

import com.solo.system.api.SysLogOperateApi;
import com.solo.system.api.entity.SysLogOperate;
import com.solo.system.mapper.SysLogOperateMapper;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * 操作日志api实现类
 * @author 十一
 * @since 2023/12/15 10:41
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
@DubboService
public class SysLogOperateApiImpl implements SysLogOperateApi {

    @Resource
    private SysLogOperateMapper sysOperateLogMapper;

    @Override
    public int save(SysLogOperate entity) {
        return sysOperateLogMapper.insert(entity);
    }

}
