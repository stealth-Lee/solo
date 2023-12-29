package com.solo.system.model.role.req;

import com.solo.system.api.consts.global.GlobalStatus;
import com.solo.system.api.consts.role.DataScope;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 系统角色新增对象
 * @author 十一
 * @since 2023/09/22 17:33
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class RoleCreateReq {

    /**
     * 角色名称
     */
    @NotEmpty(message = "{role.required.name}")
    @Size(message = "{role.size.name}", max = 32)
    private String name;

    /**
     * 角色编码
     */
    @NotEmpty(message = "{role.required.code}")
    @Size(message = "{role.size.code}", max = 32)
    private String code;

    /**
     * 数据范围
     */
    @NotNull(message = "{role.required.dataScope}")
    private DataScope dataScope;

    /**
     * 状态
     */
    @NotNull(message = "{role.required.status}")
    private GlobalStatus status;

    /**
     * 备注
     */
    @Size(message = "{role.size.remark}", max = 512)
    private String remark;


}
