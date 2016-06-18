package com.panda.iweb.service.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.panda.iweb.entity.Course;
import com.panda.iweb.service.TestService;

@Component
@Scope("prototype")
public class ServiceTask implements Runnable {

	@Resource
	private TestService testService;
	private Course course;
	private boolean isThrowException;

	@Override
	public void run() {
		testService.addCourse(course);
		if (isThrowException) {
			throw new RuntimeException("addStudentAndCourse exception");
		}
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public boolean isThrowException() {
		return isThrowException;
	}

	public void setThrowException(boolean isThrowException) {
		this.isThrowException = isThrowException;
	}

}
