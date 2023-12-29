package com.solo.system.model.role.req;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Collections;
import java.util.Set;

/**
 * 角色菜单权限修改对象
 * @author Gentleman.Lee
 * @since 2023/12/25 16:42
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class RoleMenuReq {

    @NotNull(message = "{role.required.roleId}")
    private Long roleId;

    private Set<Long> menuIds = Collections.emptySet();;

}
