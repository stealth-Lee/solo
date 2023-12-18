package com.solo.system.model.operate.req;

import com.solo.common.orm.core.query.anno.Query;
import com.solo.common.orm.core.query.anno.Wrappers;
import com.solo.common.orm.core.query.enums.QueryMode;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 操作日志查询对象 req
 * @author 十一
 * @since 2023-12-14 15:18
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@Wrappers
public class OperateLogQueryReq {

    /**
     * 日志标题
     */
    @Query
    private String title;

    /**
     * 日志类型[1新增 2删除 3修改 4查询 5其它]
     */
    @Query
    private Integer type;

    /**
     * 方法名称
     */
    @Query
    private String method;

    /**
     * 创建时间区间[开始时间,结束时间]
     */
    @Query(mode = QueryMode.BETWEEN)
    private LocalDateTime[] createTime;

}
