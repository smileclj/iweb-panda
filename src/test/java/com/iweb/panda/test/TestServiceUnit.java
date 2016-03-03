package com.iweb.panda.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iweb.panda.entity.Course;
import com.iweb.panda.entity.Student;
import com.iweb.panda.service.TestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestServiceUnit {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private TestService testService;

	@Test
	public void addStudentAndCourse() {
		Student student = new Student();
		student.setName("小贵");
		student.setSex(1);
		student.setCreateTime(new Date());

		Course course = new Course();
		course.setName("数学");
		course.setCreateTime(new Date());

		testService.getAddStudentAndCourse(student, course, true);
		logger.info("student,name:{},id:{}", student.getName(), student.getId());
		logger.info("course,name:{},id:{}", course.getName(), course.getId());
	}
}
