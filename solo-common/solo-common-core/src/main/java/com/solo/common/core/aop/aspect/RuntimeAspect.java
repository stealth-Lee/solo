package com.solo.common.core.aop.aspect;

import com.solo.common.core.aop.annotation.Runtime;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@Aspect
@Slf4j
public class RuntimeAspect {

    @Around("@annotation(runtime)")
    public Object exportExcel(ProceedingJoinPoint joinPoint, Runtime runtime) {
        Object proceed;
        long startTime = System.nanoTime();
        try {
            proceed = joinPoint.proceed(joinPoint.getArgs());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            Duration time = Duration.ofNanos(System.nanoTime() - startTime);
            log.info("执行结束，消耗了：" + time.getSeconds() + "s");
        }
        return proceed;
    }

}
