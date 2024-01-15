package com.solo.common.logger.listener;

import com.solo.common.logger.event.LoginLogEvent;
import com.solo.common.logger.event.OperateLogEvent;
import com.solo.system.api.SysLogLoginApi;
import com.solo.system.api.SysLogOperateApi;
import com.solo.system.api.entity.SysLogLogin;
import com.solo.system.api.entity.SysLogOperate;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 日志监听器，监听日志事件，将日志信息保存到数据库中
 * @author 十一
 * @since 2023/12/15 10:36
 * 人生若只如初见，何事秋风悲画扇
 **/
@Component
public class LoggerListener {

    @DubboReference
    private SysLogOperateApi sysLogOperateApi;
    @DubboReference
    private SysLogLoginApi sysLogLoginApi;

    /**
     * 异步保存系统操作日志
     * @param event 事件
     */
    @Async//异步处理
    @EventListener(OperateLogEvent.class)
    public void saveSysOperateLog(OperateLogEvent event) {
        SysLogOperate sysLog = (SysLogOperate) event.getSource();
        long id = Thread.currentThread().getId();
        System.out.println("监听到日志操作事件：" + sysLog + " 线程id：" + id);
        int save = sysLogOperateApi.save(sysLog);
    }

    /**
     * 异步系统登录日志
     * @param event 事件
     */
    @Async
    @EventListener(LoginLogEvent.class)
    public void saveSysLoginLog(LoginLogEvent event) {
        SysLogLogin sysLog = (SysLogLogin) event.getSource();
        int save = sysLogLoginApi.save(sysLog);
    }

}
