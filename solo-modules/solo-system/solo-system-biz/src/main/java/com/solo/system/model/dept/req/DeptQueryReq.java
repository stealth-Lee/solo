package com.solo.system.model.dept.req;

import com.solo.common.orm.core.query.anno.Query;
import com.solo.common.orm.core.query.anno.Wrappers;
import com.solo.common.orm.core.query.enums.QueryMode;
import lombok.Data;

/**
 * 部门查询实体类
 * @author 十一
 * @since 2023/09/08 11:33
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@Wrappers
public class DeptQueryReq {

    /**
     * 部门名称
     */
    @Query(mode = QueryMode.LIKE)
    private String deptName;

    /**
     * 部门编码
     */
    @Query
    private String deptCode;

}
