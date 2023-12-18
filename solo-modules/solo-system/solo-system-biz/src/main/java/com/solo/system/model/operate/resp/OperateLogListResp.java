package com.solo.system.model.operate.resp;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 操作日志列表对象 resp
 * @author 十一
 * @since 2023-12-14 15:18
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class OperateLogListResp {

    /**
     * id
     */
    private Long operateId;

    /**
     * 日志标题
     */
    private String title;

    /**
     * 日志类型[1新增 2删除 3修改 4查询 5其它]
     */
    private Integer type;

    /**
     * 方法名称
     */
    private String method;

    /**
     * 请求地址
     */
    private String requestUrl;

    /**
     * 请求方式
     */
    private String requestMethod;

    /**
     * 用户IP
     */
    private String userIp;

    /**
     * 设备名称/操作系统
     */
    private String deviceName;

    /**
     * 浏览器名称
     */
    private String browserName;

    /**
     * 执行时间(单位:毫秒)
     */
    private Integer executionTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 备注
     */
    private String remark;

}
