package com.solo.system.model.dict.data.req;

import com.solo.common.orm.core.query.anno.Query;
import com.solo.common.orm.core.query.anno.Wrappers;
import lombok.Data;

/**
 * 字典数据查询对象 req
 * @author 十一
 * @since 2023-10-27 15:58
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@Wrappers
public class DictDataQueryReq {

    /**
     * 字典编码
     */
    @Query
    private String dictCode;

    /**
     * 字典键值
     */
    @Query
    private String dictValue;

    /**
     * 字典标签
     */
    @Query
    private String dictLabel;

    /**
     * 状态[0禁用 1正常]
     */
    @Query
    private Boolean status;

}
