package com.solo.system.api.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户岗位实体类
 * @author 十一
 * @since 2024-02-20 14:42
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@Table("sys_user_post")
public class SysUserPost implements Serializable {

    /**
     * 用户id
     */
    @Id
    private Long userId;

    /**
     * 岗位id
     */
    @Id
    private Long postId;

}
