package com.solo.codegen.model.column.resp;

import com.solo.codegen.api.constant.column.FormType;
import com.solo.codegen.api.constant.column.JavaType;
import com.solo.codegen.api.constant.column.QueryMode;
import com.solo.system.api.constant.global.YesNo;
import lombok.Data;

/**
 * 代码生成列列表响应实体类
 * @author 十一
 * @since 2023/10/11 15:40
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class ColumnListResp {

    /**
     * 列id
     */
    private Long columnId;

    /**
     * 列名
     */
    private String columnName;

    /**
     * 列类型
     */
    private String columnType;

    /**
     * 列排序
     */
    private String columnSort;

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
    private YesNo isPk;

    /**
     * 是否插入字段
     */
    private YesNo isInsert;

    /**
     * 是否更新字段
     */
    private YesNo isUpdate;

    /**
     * 是否必填字段
     */
    private YesNo isRequired;

    /**
     * 是否列表字段
     */
    private YesNo isList;

    /**
     * 是否查询字段
     */
    private YesNo isQuery;

    /**
     * 查询方式[EQ:等于 ]
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
