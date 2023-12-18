package com.solo.common.logger.listener;

import com.solo.common.logger.event.LoggerEvent;
import com.solo.system.api.SysOperateLogApi;
import com.solo.system.api.entity.SysOperateLog;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 日志监听器，监听日志事件，将日志信息保存到数据库中
 * @author Gentleman.Lee
 * @since 2023/12/15 10:36
 * 人生若只如初见，何事秋风悲画扇
 **/
@Component
public class LoggerListener {

    @DubboReference
    private SysOperateLogApi sysOperateLogApi;

    @Async//异步处理
    @EventListener(LoggerEvent.class)
    public void saveSysLog(LoggerEvent event) {
        SysOperateLog sysLog = (SysOperateLog) event.getSource();
        long id = Thread.currentThread().getId();
        System.out.println("监听到日志操作事件：" + sysLog + " 线程id：" + id);
        //将日志信息保存到数据库...
        int save = sysOperateLogApi.save(sysLog);
    }

}
