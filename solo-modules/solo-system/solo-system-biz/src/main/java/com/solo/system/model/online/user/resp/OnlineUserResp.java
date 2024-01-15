package com.solo.system.model.online.user.resp;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 在线用户返回实体类
 * @author 十一
 * @since 2023/12/28 15:06
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class OnlineUserResp {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    private Integer number;

}
