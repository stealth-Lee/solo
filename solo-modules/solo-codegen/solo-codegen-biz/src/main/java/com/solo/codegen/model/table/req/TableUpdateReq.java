package com.solo.codegen.model.table.req;

import com.solo.codegen.api.entity.GenColumn;
import com.solo.codegen.api.entity.GenTable;
import lombok.Data;

import java.util.List;

/**
 * 代码生成业务表修改对象类
 * @author 十一
 * @since 2023/10/20 16:49
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class TableUpdateReq {

    /**
     * 业务表对象
     */
    private GenTable table;

    /**
     * 业务字段列表
     */
    private List<GenColumn> columns;

}
