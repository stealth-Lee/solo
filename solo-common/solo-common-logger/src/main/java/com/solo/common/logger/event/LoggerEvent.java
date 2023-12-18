package com.solo.common.logger.event;

import com.solo.system.api.entity.SysOperateLog;
import org.springframework.context.ApplicationEvent;

/**
 * 事件类，封装日志类 https://blog.csdn.net/qq_42306803/article/details/129856382
 * @author Gentleman.Lee
 * @since 2023/12/15 10:28
 * 人生若只如初见，何事秋风悲画扇
 **/
public class LoggerEvent extends ApplicationEvent {

    public LoggerEvent(SysOperateLog source) {
        super(source);
    }

}
