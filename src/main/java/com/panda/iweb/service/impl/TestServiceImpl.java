package com.panda.iweb.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.panda.iweb.entity.Course;
import com.panda.iweb.entity.Student;
import com.panda.iweb.mapper.CourseMapperExt;
import com.panda.iweb.mapper.StudentMapperExt;
import com.panda.iweb.service.TestService;
import com.panda.iweb.util.JsonUtil;

@Service("testService")
public class TestServiceImpl implements TestService {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private StudentMapperExt studentMapperExt;
	@Resource
	private CourseMapperExt courseMapperExt;
	@Resource
	private ThreadPoolTaskExecutor pool;

	@Override
	public void addStudent(Student student) {
		studentMapperExt.insertSelective(student);
	}

	@Override
	public void addCourse(Course course) {
		courseMapperExt.insertSelective(course);
	}

	@Override
	public void addStudentAndCourse(Student student, Course course, boolean throwException) {
		addStudent(student);
		pool.execute(new Runnable() {
			@Override
			public void run() {
				addCourse(course);
				if (throwException) {
					throw new RuntimeException("addStudentAndCourse exception");
				}
			}
		});
	}

	@Override
	public void getAddStudentAndCourse(Student student, Course course, boolean throwException) {
		addStudent(student);
		if (throwException) {
			throw new RuntimeException("addStudentAndCourse exception");
		}
		addCourse(course);
	}

	@Override
	public void getStudentById(int id) {
		logger.info("student query:{}", JsonUtil.toJsonString(studentMapperExt.selectByPrimaryKey(id)));
	}

}
