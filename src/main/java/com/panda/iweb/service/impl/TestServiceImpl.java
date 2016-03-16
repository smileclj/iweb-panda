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
	@Resource
	private TestService testService;

	@Override
	public void addStudent(Student student) {
		studentMapperExt.insertSelective(student);
	}

	@Override
	public void addCourse(Course course) {
		courseMapperExt.insertSelective(course);
	}

	@Override
	public void addCourse(Course course, boolean throwException) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addStudentAndCourse(Student student, Course course, boolean throwException) throws Exception {
		addStudent(student);
		addCourse(course);
		if (throwException) {
			throw new Exception("addStudentAndCourse exception");
			// throw new RuntimeException("addStudentAndCourse exception");
		}
		// ServiceTask task = new ServiceTask();
		// task.setCourse(course);
		// task.setThrowException(true);
		// pool.execute(task);
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

	@Override
	public void getStudentByIdWithSync(int id) {
		logger.info("student query:{}", JsonUtil.toJsonString(studentMapperExt.findStudentByIdWithXLock(id)));
	}

	@Override
	public void testThreadXLock() {
		getStudentByIdWithSync(1);
		pool.execute(new Runnable() {
			@Override
			public void run() {
				getStudentByIdWithSync(1);
				logger.info("sub");
			}
		});
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		logger.info("main");

	}
}
