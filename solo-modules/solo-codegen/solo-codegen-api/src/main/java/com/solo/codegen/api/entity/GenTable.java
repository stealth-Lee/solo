package com.solo.codegen.api.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.solo.codegen.api.constant.table.TplType;
import com.solo.common.orm.base.entity.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 代码生成业务表实体类
 * @author 十一
 * @since 2023/10/08 15:35
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Table("gen_table")
public class GenTable extends BasicEntity {

    /**
     * 业务表id
     */
    @Id(keyType = KeyType.Auto)
    private Long tableId;

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 表描述
     */
    private String tableComment;

    /**
     * 作者
     */
    private String author;

    /**
     * 模版类型[1:单表结构 2:树表结构 3:主子表结构]
     */
    private TplType tplType;

    /**
     * 生成包路径
     */
    private String packageName;

    /**
     * 生成模块名
     */
    private String moduleName;

    /**
     * 生成业务名
     */
    private String businessName;

    /**
     * 生成功能名
     */
    private String functionName;

    /**
     * 实体类名称
     */
    private String className;

}
