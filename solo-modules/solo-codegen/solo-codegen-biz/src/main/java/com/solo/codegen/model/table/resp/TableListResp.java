package com.solo.codegen.model.table.resp;

import com.solo.codegen.api.consts.table.TplType;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 代码生成业务表实体类列表返回类
 * @author 十一
 * @since 2023/10/08 15:46
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class TableListResp {

    /**
     * 表id
     */
    private Long tableId;

    /**
     * 表名称
     */
    private String name;

    /**
     * 表描述
     */
    private String comment;

    /**
     * 作者
     */
    private String author;

    /**
     * 模版类型
     */
    private TplType tplType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 备注
     */
    private String remark;

}
