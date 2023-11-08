package com.solo.codegen.model.table.resp;

import lombok.Data;

/**
 * 代码生成业务表列表简单响应对象
 * @author 十一
 * @since 2023/10/10 15:06
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class TableListSimpleResp {

    /**
     * 表名称
     */
    private String name;

    /**
     * 表描述
     */
    private String comment;

}
