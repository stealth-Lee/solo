package com.solo.system.model.config.req;

import com.solo.common.orm.core.query.anno.Query;
import com.solo.common.orm.core.query.anno.Wrappers;
import lombok.Data;

/**
 * 系统配置查询对象 req
 * @author 十一
 * @since 2023-10-18 16:46
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@Wrappers
public class ConfigQueryReq {

    /**
     * 配置名称
     */
    @Query
    private String name;

    /**
     * 配置键
     */
    @Query
    private String key;

    /**
     * 配置值
     */
    @Query
    private String value;

    /**
     * 系统标识[0:否 1:是]
     */
    @Query
    private Boolean isSys;

}
