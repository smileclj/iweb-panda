package com.iweb.panda.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MethodMonitorAop {

	private static final Logger logger = LoggerFactory.getLogger(MethodMonitorAop.class);

	@Pointcut("execution(* com.iweb.panda.service.impl.*.*(..))")
	public void controller() {
	}

	@Before("controller()")
	public void before() {
		logger.info("method execute before");
	}

	@After("controller()")
	public void after() {
		logger.info("method execute after");
	}

	@AfterReturning("controller()")
	public void afterReturning() {
		logger.info("method execute afterReturning");
	}
	
	@AfterThrowing("controller()")
	public void afterThrowing() {
		logger.info("method execute afterThrowing");
	}

	@Around("controller()")
	public Object around(ProceedingJoinPoint p) throws Throwable {
		long start = System.currentTimeMillis();
		Object r = p.proceed();
		long end = System.currentTimeMillis();
		logger.info("方法{}执行耗时{}ms", p.getSignature().toString(), end - start);
		return r;
	}

}
