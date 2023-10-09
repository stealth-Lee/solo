package com.solo.codegen.model.table.req;

import com.solo.common.orm.core.query.anno.Query;
import com.solo.common.orm.core.query.anno.Wrappers;
import com.solo.common.orm.core.query.enums.QueryMode;
import lombok.Data;

/**
 * 代码生成业务表查询对象类
 * @author 十一
 * @since 2023/10/08 15:47
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@Wrappers
public class TableQueryReq {

    /**
     * 表名称
     */
    @Query(mode = QueryMode.LIKE)
    private String tableName;

    /**
     * 表描述
     */
    @Query(mode = QueryMode.LIKE)
    private String tableComment;

}
