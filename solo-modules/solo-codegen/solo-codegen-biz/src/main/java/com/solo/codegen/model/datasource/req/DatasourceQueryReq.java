package com.solo.codegen.model.datasource.req;

import com.solo.common.orm.core.query.anno.Query;
import com.solo.common.orm.core.query.anno.Wrappers;
import lombok.Data;

@Data
@Wrappers
public class DatasourceQueryReq {

    /**
     * 别名
     */
    @Query
    private String name;

}
