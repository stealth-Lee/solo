package com.solo.codegen.model.table.req;

import lombok.Data;

/**
 * 代码生成业务表创建请求对象
 * @author 十一
 * @since 2023/10/11 09:55
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class TableCreateReq {

    /**
     * 数据源id
     */
    private Long sourceId;

    /**
     * 表名称
     */
    private String tableName;

}
