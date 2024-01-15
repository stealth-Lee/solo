package com.solo.common.logger.aspect;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import com.alibaba.fastjson2.JSON;
import com.solo.common.core.utils.ServletUtils;
import com.solo.common.logger.annotation.Logger;
import com.solo.common.logger.event.OperateLogEvent;
import com.solo.system.api.entity.SysLogOperate;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 操作日志切面
 * @author 十一
 * @since 2023/12/14 16:20
 * 人生若只如初见，何事秋风悲画扇
 **/
@Slf4j
@Aspect
@Component
public class LoggerAspect {

    /**
     * 环绕处理
     * @param point  点
     * @param logger 记录
     * @return {@link Object}
     */
    @SneakyThrows
    @Around("@annotation(logger)")
    public Object around(ProceedingJoinPoint point, Logger logger) {
        HttpServletRequest request = ServletUtils.getRequest();
        SysLogOperate operateLog = new SysLogOperate();
        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
        operateLog.setTitle(logger.value());
        operateLog.setMethod(className + "." + methodName + "()");
        operateLog.setType(logger.type().getValue());
        operateLog.setRequestUrl(request.getRequestURI());
        operateLog.setRequestMethod(request.getMethod());
        // TODO POST/PUT请求参数获取不到
        operateLog.setRequestData(JSON.toJSONString(ServletUtils.getParams(request)));
        String clientIP = ServletUtils.getClientIP(request);
        operateLog.setUserIp(clientIP);
        String userAgent = ServletUtils.getUserAgent(request);
        operateLog.setUserAgent(userAgent);
        UserAgent ua = UserAgentUtil.parse(userAgent);
        operateLog.setDeviceName(ua.getPlatform().getName());
        operateLog.setBrowserName(ua.getBrowser().getName());

        Object object;
        LocalDateTime startTime = LocalDateTime.now();
        try {
            object = point.proceed();
            operateLog.setResponseData(JSON.toJSONString(object));
        } catch (Exception e) {
            operateLog.setExceptionInfo(e.getMessage());
            throw e;
        } finally {
            LocalDateTime endTime = LocalDateTime.now();
            operateLog.setExecutionTime((int) LocalDateTimeUtil.between(startTime, endTime).toMillis());
            SpringUtil.publishEvent(new OperateLogEvent(operateLog));
        }
        return object;
    }

}
