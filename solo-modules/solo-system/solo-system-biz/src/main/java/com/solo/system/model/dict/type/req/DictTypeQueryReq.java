package com.solo.system.model.dict.type.req;

import com.solo.common.orm.core.query.anno.Query;
import com.solo.common.orm.core.query.anno.Wrappers;
import com.solo.system.api.consts.global.GlobalStatus;
import lombok.Data;

/**
 * 字典类型查询对象类
 * @author 十一
 * @since 2023/09/22 17:07
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@Wrappers
public class DictTypeQueryReq {

    /**
     * 字典类型名称
     */
    @Query
    private String name;

    /**
     * 字典类型编码
     */
    @Query
    private String code;

    /**
     * 字典类型状态
     */
    @Query
    private GlobalStatus status;

}
