package com.solo.system.service;

import com.solo.common.core.base.service.BasicService;
import com.solo.system.api.entity.SysUser;
import com.solo.system.model.user.req.UserResetPasswordReq;

/**
 * 用户Service
 * @author 十一
 * @since 2023/09/04 17:26
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface SysUserService extends BasicService<SysUser> {

    /**
     * 新增用户
     * @param entity 用户实体
     * @return 是否成功
     */
    boolean create(SysUser entity);

    /**
     * 重置密码
     * @param req 用户重置密码请求对象
     */
    void resetPassword(UserResetPasswordReq req);

    /**
     * 更新用户
     * @param entity 用户实体
     * @return 是否成功
     */
    boolean update(SysUser entity);
}
