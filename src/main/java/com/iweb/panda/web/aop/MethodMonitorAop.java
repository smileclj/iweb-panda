package com.iweb.panda.web.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MethodMonitorAop {

    private static final Logger logger = LoggerFactory.getLogger(MethodMonitorAop.class);

    @Pointcut("execution(* com.iweb.panda.controller..*.*(..))")
    public void controller() {
    }

    @Around("controller()")
    public Object around(ProceedingJoinPoint p) throws Throwable {
        long start = System.currentTimeMillis();
        Object r = p.proceed();
        long end = System.currentTimeMillis();
        logger.info("方法{}执行耗时{}秒", p.getSignature().toString(), (end - start) / 1000);
        return r;
    }
}
