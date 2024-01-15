package com.solo.system.dubbo;

import com.mybatisflex.core.query.QueryChain;
import com.solo.system.api.SysConfigApi;
import com.solo.system.api.entity.SysConfig;
import com.solo.system.mapper.SysConfigMapper;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import static com.solo.system.api.entity.table.SysConfigTableDef.SysConfigTable;

/**
 * 系统配置实现类
 * @author 十一
 * @since 2023/12/11 17:14
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
@DubboService
public class SysConfigApiImpl implements SysConfigApi {

    @Resource
    private SysConfigMapper sysConfigMapper;

    public SysConfig selectConfigByKey(String key) {
        return QueryChain.of(sysConfigMapper).where(SysConfigTable.Key.eq(key)).one();
    }

}
