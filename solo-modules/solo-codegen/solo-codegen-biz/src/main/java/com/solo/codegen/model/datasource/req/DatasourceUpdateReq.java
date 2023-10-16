package com.solo.codegen.model.datasource.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 数据源更新对象
 * @author 十一
 * @since 2023/10/09 11:01
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class DatasourceUpdateReq extends DatasourceCreateReq {

    /**
     * 数据源id
     */
    private Long sourceId;

}
