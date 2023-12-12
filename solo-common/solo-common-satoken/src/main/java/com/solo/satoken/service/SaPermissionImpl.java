package com.solo.satoken.service;

import cn.dev33.satoken.stp.StpInterface;
import com.solo.satoken.utils.LoginHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户权限管理实现类
 * @author 十一
 * @since 2023/11/24 16:24
 * 人生若只如初见，何事秋风悲画扇
 **/
public class SaPermissionImpl implements StpInterface {


    /**
     * 获取权限列表
     * @param loginId 账号id
     * @param loginType 账号体系标识, 详见https://sa-token.cc/doc.html#/up/many-account
     * @return {@link List}<{@link String}>
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return new ArrayList<>(LoginHelper.getLoginUser().getMenuPermissions());
    }

    /**
     * 获取角色列表
     * @param loginId 账号id
     * @param loginType 账号体系标识, 详见https://sa-token.cc/doc.html#/up/many-account
     * @return {@link List}<{@link String}>
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return new ArrayList<>(LoginHelper.getLoginUser().getRolePermissions());
    }

}
