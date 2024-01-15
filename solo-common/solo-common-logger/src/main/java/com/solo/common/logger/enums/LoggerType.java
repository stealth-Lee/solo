package com.solo.common.logger.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 日志类型枚举
 * @author 十一
 * @since 2023/12/18 11:04
 * 人生若只如初见，何事秋风悲画扇
 **/
@Getter
@AllArgsConstructor
public enum LoggerType {

    /**
     * 其它
     */
    OTHER(0),

    /**
     * 新增
     */
    CREATE(1),

    /**
     * 删除
     */
    DELETE(2),

    /**
     * 修改
     */
    UPDATE(3),

    /**
     * 查询
     */
    QUERY(4),

    /**
     * 导入
     */
    IMPORT(5),

    /**
     * 导出
     */
    EXPORT(6);

    private final Integer value;

}
