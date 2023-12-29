package com.solo.system.model.user.resp;

import com.solo.system.api.consts.global.GlobalStatus;
import com.solo.system.api.consts.user.Sex;
import lombok.Data;

/**
 * 用户详情返回实体类
 * @author 十一
 * @since 2023/09/21 15:35
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class UserGetResp {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 所属部门id
     */
    private Long deptId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户名
     */
    private String password;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户性别[0男 1女]
     */
    private Sex sex;

    /**
     * 用户电话
     */
    private String mobile;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 帐号状态[0正常 1停用]
     */
    private GlobalStatus status;

    /**
     * 备注
     */
    private String remark;

}
