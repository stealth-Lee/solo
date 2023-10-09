package com.solo.codegen.api.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.solo.common.orm.base.entity.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 代码生成数据源实体类
 *
 * @author 十一
 * @since 2023/10/08 17:30
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Table("gen_datasource")
public class GenDatasource extends BasicEntity {

    /**
     * 数据源id
     */
    @Id(keyType = KeyType.Auto)
    private Long sourceId;

    /**
     * 别名
     */
    private String name;

    /**
     * 数据源连接
     */
    private String url;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
