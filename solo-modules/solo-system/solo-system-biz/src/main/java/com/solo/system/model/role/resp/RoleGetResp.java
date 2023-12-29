package com.solo.system.model.role.resp;

import com.solo.system.api.consts.global.GlobalStatus;
import com.solo.system.api.consts.role.DataScope;
import lombok.Data;

/**
 * 系统角色详情对象
 * @author 十一
 * @since 2023/09/25 13:38
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class RoleGetResp {

    /**
     * 角色id
     */
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

    /**
     * 备注
     */
    private String remark;

}
