package com.solo.system.api.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 登录日志实体类
 * @author 十一
 * @since 2023-12-14 15:18
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@Table("sys_log_login")
public class SysLogLogin implements Serializable {

    /**
     * 登录日志id
     */
    @Id(keyType = KeyType.Auto)
    private String loginId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录ip地址
     */
    private String ip;

    /**
     * 登录地点
     */
    private String location;

    /**
     * 用户代理
     */
    private String userAgent;

    /**
     * 设备名称/操作系统
     */
    private String deviceName;

    /**
     * 浏览器名称
     */
    private String browserName;

    /**
     * 登录状态[0失败 1成功]
     */
    private String status;

    /**
     * 登录时间
     */
    private LocalDateTime loginTime;

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
