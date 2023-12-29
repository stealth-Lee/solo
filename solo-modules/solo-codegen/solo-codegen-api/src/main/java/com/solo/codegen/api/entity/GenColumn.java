package com.solo.codegen.api.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.solo.codegen.api.consts.column.FormType;
import com.solo.codegen.api.consts.column.JavaType;
import com.solo.codegen.api.consts.column.QueryMode;
import com.solo.common.core.base.entity.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 代码生成业务表字段实体类
 * @author 十一
 * @since 2023/10/10 17:09
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Table("gen_column")
public class GenColumn extends BasicEntity {

    /**
     * 列id
     */
    @Id(keyType = KeyType.Auto)
    private Long columnId;

    /**
     * 表id
     */
    private Long tableId;

    /**
     * 列名
     */
    private String name;

    /**
     * 列类型
     */
    private String type;

    /**
     * 列长度
     */
    private Integer length;

    /**
     * 列排序
     */
    private Integer sort;

    /**
     * Java类型
     */
    private JavaType javaType;

    /**
     * Java字段名
     */
    private String javaField;

    /**
     * Java说明
     */
    private String javaComment;

    /**
     * 是否主键
     */
    private Boolean isPk;

    /**
     * 是否插入字段
     */
    private Boolean isCreate;

    /**
     * 是否更新字段
     */
    private Boolean isUpdate;

    /**
     * 是否必填字段
     */
    private Boolean isRequired;

    /**
     * 是否列表字段
     */
    private Boolean isList;

    /**
     * 是否查询字段
     */
    private Boolean isQuery;

    /**
     * 查询方式
     */
    private QueryMode queryMode;

    /**
     * 表单类型
     */
    private FormType formType;

    /**
     * 字典
     */
    private String dictCode;

}
