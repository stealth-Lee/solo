package com.solo.system.model.operate.req;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 操作日志新增对象 req
 * @author 十一
 * @since 2023-12-14 15:18
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class OperateLogCreateReq {

    /**
     * 日志标题
     */
    @NotEmpty(message = "{operateLog.requ.title}")
    @Size(message = "{operateLog.size.title}", max = 32)
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
     * 请求数据
     */
    private String requestData;

    /**
     * 响应数据
     */
    private String responseData;

    /**
     * 异常信息
     */
    private String exceptionInfo;

    /**
     * 用户IP
     */
    private String userIp;

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
     * 执行时间(单位:毫秒)
     */
    private Integer executionTime;

    /**
     * 备注
     */
    private String remark;

}
