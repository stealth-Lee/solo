package com.solo.system.model.user.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户更新实体类
 * @author 十一
 * @since 2023/09/21 14:30
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class UserUpdateReq extends UserCreateReq {

    /**
     * 用户id
     */
    private Long userId;

}
