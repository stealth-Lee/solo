package com.solo.system.model.role.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统角色修改对象
 * @author 十一
 * @since 2023/09/25 10:47
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleUpdateReq extends RoleCreateReq {

    /**
     * 角色id
     */
    private Long roleId;

}
