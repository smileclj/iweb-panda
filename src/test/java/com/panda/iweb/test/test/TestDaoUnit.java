package com.panda.iweb.test.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.panda.iweb.mapper.CourseMapperExt;
import com.panda.iweb.mapper.StudentMapperExt;
import com.panda.iweb.entity.Student;
import com.panda.iweb.util.JsonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestDaoUnit {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private StudentMapperExt studentMapperExt;
	@Resource
	private CourseMapperExt courseMapperExt;

	@Test
	public void addStudent() {
		Student student = new Student();
		student.setName("小张");
		student.setSex(1);
		student.setCreateTime(new Date());
		logger.info("result:{}", studentMapperExt.insertSelective(student));
		logger.info("id:{}", student.getId());
	}

	@Test
	public void getStudent() {
		Student student = studentMapperExt.findStudentById(1);
		logger.info(JsonUtil.toJsonString(student));
	}
}
