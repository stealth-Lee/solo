package com.solo.system.model.role.req;

import com.solo.system.api.constant.global.GlobalStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 系统角色修改状态对象
 * @author 十一
 * @since 2023/10/07 15:09
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class RoleUpdateStatusReq {

    /**
     * 角色id
     */
    @NotNull(message = "角色编号不能为空")
    private Long roleId;

    /**
     * 状态
     */
    @NotNull(message = "角色状态不能为空")
    private GlobalStatus status;

}
