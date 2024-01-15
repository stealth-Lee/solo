package com.solo.system.model.log.login.resp;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 登录日志列表对象 resp
 * @author 十一
 * @since 2024/01/03 13:59
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class LogLoginListResp {

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
     * 备注
     */
    private String remark;

}
