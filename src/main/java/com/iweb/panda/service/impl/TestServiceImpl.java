package com.iweb.panda.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.iweb.panda.entity.Course;
import com.iweb.panda.entity.Student;
import com.iweb.panda.mapper.CourseMapperExt;
import com.iweb.panda.mapper.StudentMapperExt;
import com.iweb.panda.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private StudentMapperExt studentMapperExt;
	@Resource
	private CourseMapperExt courseMapperExt;

	@Override
	public void addStudent() {
		Student student = new Student();
		student.setName("小明");
		student.setSex(1);
		student.setCreateTime(new Date());
		studentMapperExt.insertSelective(student);
	}

	@Override
	public void addCourse() {
		Course course = new Course();
		course.setName("语文");
		course.setCreateTime(new Date());
		courseMapperExt.insertSelective(course);
	}

}
