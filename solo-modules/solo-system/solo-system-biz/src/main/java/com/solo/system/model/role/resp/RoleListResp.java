package com.solo.system.model.role.resp;

import com.solo.system.api.constant.global.GlobalStatus;
import com.solo.system.api.constant.role.DataScope;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 系统角色列表对象
 * @author 十一
 * @since 2023/09/25 13:41
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class RoleListResp {

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 数据范围
     */
    private DataScope dataScope;

    /**
     * 状态[0停用 1正常]
     */
    private GlobalStatus status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 备注
     */
    private String remark;

}
