package com.iweb.panda.service;

import com.iweb.panda.entity.Course;
import com.iweb.panda.entity.Student;

public interface TestService {
	void addStudent(Student student);

	void addCourse(Course course);

	void addStudentAndCourse(Student student, Course course,boolean throwException);
	
	void getAddStudentAndCourse(Student student, Course course,boolean throwException);
}
