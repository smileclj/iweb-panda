package com.iweb.panda.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.panda.iweb.entity.Course;
import com.panda.iweb.entity.Student;
import com.panda.iweb.service.TestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestServiceUnit {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private TestService testService;

	@Test
	public void addStudentAndCourse() {
		Student student = new Student();
		student.setName("小Q");
		student.setSex(1);
		student.setCreateTime(new Date());

		Course course = new Course();
		course.setName("养生");
		course.setCreateTime(new Date());

		try {
			testService.addStudentAndCourse(student, course, true);
		} catch (Exception e) {
		}
		logger.info("student,name:{},id:{}", student.getName(), student.getId());
		logger.info("course,name:{},id:{}", course.getName(), course.getId());
	}

	@Test
	public void getStudent() {
		testService.getStudentById(1);
	}

	@Test
	public void getStudentByIdWithSync() {
		testService.testThreadXLock();
	}

	@Test
	public void addStudent() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			Student student = new Student();
			student.setName("小美" + i);
			student.setSex(1);
			student.setCreateTime(new Date());
			testService.addStudent(student);
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时:" + (end - start) + "ms");
	}

	@Test
	public void addLotsOfStudents() {
		long start = System.currentTimeMillis();
		testService.addLotsOfStudents();
		long end = System.currentTimeMillis();
		System.out.println("耗时:" + (end - start) + "ms");
	}
	
	@Test
	public void addLotsOfStudents2() {
		long start = System.currentTimeMillis();
		testService.addLotsOfStudents2();
		long end = System.currentTimeMillis();
		System.out.println("耗时:" + (end - start) + "ms");
	}
}