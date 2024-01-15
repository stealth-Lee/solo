package com.solo.auth.service.impl;

import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import com.solo.auth.service.LoginService;
import com.solo.common.core.utils.ServletUtils;
import com.solo.common.logger.event.LoginLogEvent;
import com.solo.system.api.entity.SysLogLogin;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public void saveLoginLog(String username) {
        HttpServletRequest request = ServletUtils.getRequest();
        SysLogLogin loginLog = new SysLogLogin();
        loginLog.setUsername(username);
        loginLog.setIp(ServletUtils.getClientIP(request));
//        loginLog.setLocation();
        String userAgent = ServletUtils.getUserAgent(request);
        loginLog.setUserAgent(userAgent);
        UserAgent ua = UserAgentUtil.parse(userAgent);
        loginLog.setDeviceName(ua.getPlatform().getName());
        loginLog.setBrowserName(ua.getBrowser().getName());
        SpringUtil.publishEvent(new LoginLogEvent(loginLog));
    }

}
