package com.solo.system.api.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.solo.common.orm.base.entity.BasicEntity;
import com.solo.system.api.constant.global.GlobalStatus;
import com.solo.system.api.constant.user.Sex;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户实体类
 *
 * @author 十一
 * @since 2023/08/30 17:37
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Table("sys_user")
public class SysUser extends BasicEntity {

    /**
     * 用户id
     */
    @Id(keyType = KeyType.Auto)
    private String userId;

    /**
     * 所属部门id
     */
    private Long deptId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
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
     * 用户性别
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
     * 帐号状态
     */
    private GlobalStatus status;

}
