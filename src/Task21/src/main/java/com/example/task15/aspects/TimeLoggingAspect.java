package com.example.task15.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class TimeLoggingAspect {
    @Around("allServiceMethods()")
    public Object logTimeOfExecution(ProceedingJoinPoint proceedingJoinPoint) {
        long startTime = System.currentTimeMillis();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        String methodName = proceedingJoinPoint.getSignature().toShortString();
        Number timeMS = endTime - startTime;
        log.info("{} - {}ms", methodName, timeMS);
        return result;
    }

    @Pointcut("within(com.example.task15.services.*)")
    public void allServiceMethods() {}
}
