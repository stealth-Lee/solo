package com.solo.common.logger.event;

import com.solo.system.api.entity.SysLogLogin;
import org.springframework.context.ApplicationEvent;

/**
 * 封装登录日志事件
 * @author 十一
 * @since 2024/01/03 10:56
 * 人生若只如初见，何事秋风悲画扇
 **/
public class LoginLogEvent extends ApplicationEvent {

    public LoginLogEvent(SysLogLogin source) {
        super(source);
    }

}