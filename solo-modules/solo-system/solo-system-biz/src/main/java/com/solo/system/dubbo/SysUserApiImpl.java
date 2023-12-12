package com.solo.system.dubbo;

import com.mybatisflex.core.query.QueryChain;
import com.solo.system.api.SysUserApi;
import com.solo.system.api.entity.SysUser;
import com.solo.system.mapper.SysUserMapper;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import static com.solo.system.api.entity.table.SysUserTableDef.SysUserTable;

/**
 * 系统用户远程调用实现类
 * @author 十一
 * @since 2023/11/30 10:51
 * 人生若只如初见，何事秋风悲画扇
 **/
@Service
@DubboService
public class SysUserApiImpl implements SysUserApi {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser query(String username) {
        return QueryChain.of(sysUserMapper).where(SysUserTable.Username.eq(username)).one();
    }

}
