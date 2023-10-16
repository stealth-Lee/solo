package com.solo.codegen.model.datasource.resp;

import lombok.Data;

/**
 * 数据源列表简单响应对象类
 * @author 十一
 * @since 2023/10/10 09:50
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class DatasourceListSimpleResp {

    /**
     * 数据源id
     */
    private Long sourceId;

    /**
     * 别名
     */
    private String name;


}
