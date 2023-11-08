package com.solo.system.model.role.req;

import com.solo.common.orm.core.query.anno.Query;
import com.solo.common.orm.core.query.anno.Wrappers;
import com.solo.common.orm.core.query.enums.QueryMode;
import com.solo.system.api.constant.global.GlobalStatus;
import lombok.Data;

@Data
@Wrappers
public class RoleQueryReq {

    /**
     * 角色名称
     */
    @Query(mode = QueryMode.LIKE)
    private String name;

    /**
     * 角色编码
     */
    @Query
    private String code;

    /**
     * 状态[0停用 1正常]
     */
    @Query
    private GlobalStatus status;

}
