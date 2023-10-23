package com.solo.system.model.user.req;

import com.solo.common.orm.core.query.anno.Query;
import com.solo.common.orm.core.query.anno.Wrappers;
import com.solo.system.api.constant.global.GlobalStatus;
import lombok.Data;

@Data
@Wrappers
public class UserQueryReq {

    /**
     * 所属部门id
     */
    @Query
    private Long deptId;

    /**
     * 用户名
     */
    @Query
    private String username;

    /**
     * 用户电话
     */
    @Query
    private String mobile;

    /**
     * 帐号状态[0正常 1停用]
     */
    @Query
    private GlobalStatus status;

}
