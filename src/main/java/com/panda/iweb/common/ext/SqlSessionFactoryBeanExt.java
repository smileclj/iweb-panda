package com.panda.iweb.common.ext;

import java.io.IOException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NestedIOException;

public class SqlSessionFactoryBeanExt extends SqlSessionFactoryBean {
	private static final Logger logger = LoggerFactory.getLogger(SqlSessionFactoryBeanExt.class);

	@Override
	protected SqlSessionFactory buildSqlSessionFactory() throws IOException {
		try {
			return super.buildSqlSessionFactory();
		} catch (NestedIOException e) {
			logger.error("mybatis配置文件解析失败", e);
			System.exit(0);
		}
		return null;
	}
}
