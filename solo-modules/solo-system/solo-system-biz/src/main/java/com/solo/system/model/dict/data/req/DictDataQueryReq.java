package com.solo.system.model.dict.data.req;

import com.solo.common.orm.core.query.anno.Query;
import com.solo.common.orm.core.query.anno.Wrappers;
import com.solo.common.orm.core.query.enums.QueryMode;
import com.solo.system.api.constant.global.GlobalStatus;
import lombok.Data;

/**
 * 字典数据查询对象
 * @author 十一
 * @since 2023/09/26 11:48
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@Wrappers
public class DictDataQueryReq {

    /**
     * 字典标签
     */
    @Query(mode = QueryMode.LIKE)
    private String dictLabel;

    /**
     * 状态
     */
    @Query
    private GlobalStatus status;

}
