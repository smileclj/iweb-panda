package com.iweb.panda.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.iweb.panda.entity.Course;
import com.iweb.panda.entity.Student;
import com.iweb.panda.mapper.CourseMapperExt;
import com.iweb.panda.mapper.StudentMapperExt;
import com.iweb.panda.service.TestService;
import com.iweb.panda.util.JsonUtil;

@Service("testService")
public class TestServiceImpl implements TestService {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private StudentMapperExt studentMapperExt;
	@Resource
	private CourseMapperExt courseMapperExt;

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
		if (throwException) {
			throw new RuntimeException("addStudentAndCourse exception");
		}
		addCourse(course);
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
