package com.solo.common.core.base.entity;

import com.mybatisflex.annotation.Column;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础实体类
 * @author 十一
 * @date 2023/08/30 15:30
 * 人生若只如初见，何事秋风悲画扇
 */
@Data
public class BasicEntity implements Serializable {

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 删除标志[0未删除 1已删除]
     */
    @Column(isLogicDelete = false)
    private Boolean deleted;

    /**
     * 备注
     */
    private String remark;

}
