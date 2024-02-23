package com.solo.system.service;

import com.solo.common.core.base.service.BasicService;
import com.solo.system.api.entity.SysUser;
import com.solo.system.model.user.req.ChangePasswordReq;
import com.solo.system.model.user.req.UserCreateReq;
import com.solo.system.model.user.req.ResetPasswordReq;
import com.solo.system.model.user.req.UserUpdateReq;
import com.solo.system.model.user.resp.UserGetResp;

/**
 * 用户Service
 * @author 十一
 * @since 2023/09/04 17:26
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface SysUserService extends BasicService<SysUser> {

    /**
     * 新增用户
     * @param req 用户创建对象
     * @return 是否成功
     */
    boolean create(UserCreateReq req);

    /**
     * 重置密码
     * @param req 用户重置密码请求对象
     */
    void resetPassword(ResetPasswordReq req);

    /**
     * 修改密码
     * @param req 修改密码请求对象
     */
    void changePassword(ChangePasswordReq req);

    /**
     * 更新用户
     * @param req 用户修改对象
     * @return 是否成功
     */
    boolean update(UserUpdateReq req);

    /**
     * 根据用户id查询用户详情
     * @param userId 用户id
     * @return 用户详情
     */
    UserGetResp queryByUserId(Long userId);

}
