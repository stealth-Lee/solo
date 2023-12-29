package com.solo.system.api.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.solo.common.core.base.entity.BasicEntity;
import com.solo.system.api.consts.global.GlobalStatus;
import com.solo.system.api.consts.role.DataScope;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统角色实体类
 * @author 十一
 * @since 2023/09/22 17:18
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Table("sys_role")
public class SysRole extends BasicEntity {

    /**
     * 角色id
     */
    @Id(keyType = KeyType.Auto)
    private Long roleId;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 数据范围
     */
    private DataScope dataScope;

    /**
     * 状态[0停用 1正常]
     */
    private GlobalStatus status;

}
