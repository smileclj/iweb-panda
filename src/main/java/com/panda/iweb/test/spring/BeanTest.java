package com.panda.iweb.test.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanTest implements BeanNameAware, BeanFactoryAware, ApplicationContextAware {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void setApplicationContext(ApplicationContext ac) throws BeansException {
		logger.info("注入applicationContext:{}");
	}

	@Override
	public void setBeanFactory(BeanFactory bf) throws BeansException {
		logger.info("注入beanFactory");
	}

	@Override
	public void setBeanName(String name) {
		logger.info("注入beanName:{}", name);
	}

}
