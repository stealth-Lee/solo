package com.solo.system.api.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.solo.common.core.base.entity.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统配置实体类
 * @author 十一
 * @since 2023-10-18 16:33
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Table("sys_config")
public class SysConfig extends BasicEntity {

    /**
     * 配置id
     */
    @Id(keyType = KeyType.Auto)
    private Long configId;

    /**
     * 配置名称
     */
    private String name;

    /**
     * 配置键
     */
    private String key;

    /**
     * 配置值
     */
    private String value;

    /**
     * 系统标识[0:否 1:是]
     */
    private Boolean isSys;

}
