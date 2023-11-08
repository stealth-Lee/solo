package com.solo.codegen.service;

import com.mybatisflex.codegen.entity.Table;

import java.util.List;

/**
 * 数据库表 Service
 * @author 十一
 * @since 2023/10/10 15:01
 * 人生若只如初见，何事秋风悲画扇
 **/
public interface DatabaseTableService {

    /**
     * 获取指定数据源下的表列表
     * @param sourceId 数据源id
     * @return 表列表
     */
    List<Table> getTableList(Long sourceId);

    /**
     * 获取指定数据源下指定表
     * @param sourceId 数据源id
     * @param name 表名称
     * @return 表信息
     */
    Table getTable(Long sourceId, String name);

}
