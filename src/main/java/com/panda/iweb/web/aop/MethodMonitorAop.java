package com.panda.iweb.web.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.panda.iweb.util.JsonUtil;

@Component
@Aspect
public class MethodMonitorAop {

	private static final Logger logger = LoggerFactory.getLogger(MethodMonitorAop.class);

	@Pointcut("execution(* com.panda.iweb.service.impl.*.*(..))")
	public void service() {
	}

	@Pointcut("execution(* com.panda.iweb.controller.*.*(..))")
	public void controller() {
	}

	@Before("controller()")
	public void before() {
		// logger.info("method execute before");
	}

	@After("controller()")
	public void after() {
		// logger.info("method execute after");
	}

	@AfterReturning("controller()")
	public void afterReturning() {
		// logger.info("method execute afterReturning");
	}

	@AfterThrowing("controller()")
	public void afterThrowing() {
		logger.info("method execute afterThrowing");
	}

	@Around("controller() || service()")
	public Object around(ProceedingJoinPoint p) throws Throwable {
		Object[] params = p.getArgs();
		StringBuilder sb = new StringBuilder();
		for (Object param : params) {
			if (param instanceof String || param instanceof Integer || param instanceof Long || param instanceof Short || param instanceof Double
					|| param instanceof Byte || param instanceof Float || param instanceof Boolean) {
				sb.append(param.toString());
			} else if (param instanceof HttpServletRequest || param instanceof HttpServletResponse) {
				continue;
			} else {
				sb.append(JsonUtil.toJsonString(param));
			}
			sb.append(" | ");
		}
		logger.info("方法{}的参数是:{}", p.getSignature().toString(), sb.toString());
		long start = System.currentTimeMillis();
		Object r = p.proceed();
		long end = System.currentTimeMillis();
		logger.info("方法{}执行耗时{}ms", p.getSignature().toString(), end - start);
		return r;
	}
}
