package com.solo.system.api.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.solo.common.core.base.entity.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 岗位实体类
 * @author 十一
 * @since 2024-02-18 14:13
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Table("sys_post")
public class SysPost extends BasicEntity {

    /**
     * id
     */
    @Id(keyType = KeyType.Auto)
    private Long postId;

    /**
     * 岗位名称
     */
    private String name;

    /**
     * 岗位编码
     */
    private String code;

    /**
     * 岗位排序
     */
    private Integer sort;

}
