package com.panda.iweb.common.quartz;

import java.lang.reflect.Method;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class PandaQuartzJobBean extends QuartzJobBean implements ApplicationContextAware {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private String targetObject;
	private String targetMethod;
	private ApplicationContext context;

	@Override
	protected void executeInternal(JobExecutionContext paramJobExecutionContext) throws JobExecutionException {
		try {
			// logger.info("execute [" + targetObject + "] at once>>>>>>");
			Method m = null;
			try {
				// new Class[] { JobExecutionContext.class }
				Object otargetObject = context.getBean(targetObject);
				m = otargetObject.getClass().getMethod(targetMethod, new Class[] {});
				m.invoke(otargetObject, new Object[] {});
			} catch (SecurityException e) {
				logger.error("quartz execute failed", e);
			} catch (NoSuchMethodException e) {
				logger.error("quartz execute failed", e);
			}
		} catch (Exception e) {
			throw new JobExecutionException(e);
		}
	}

	public void setTargetObject(String targetObject) {
		this.targetObject = targetObject;
	}

	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}
}
