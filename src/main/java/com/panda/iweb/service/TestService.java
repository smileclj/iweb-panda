package com.panda.iweb.service;

import com.panda.iweb.entity.Course;
import com.panda.iweb.entity.Student;

public interface TestService {
	void addStudent(Student student);

	void addCourse(Course course);

	void addStudentAndCourse(Student student, Course course, boolean throwException);

	void getAddStudentAndCourse(Student student, Course course, boolean throwException);

	void getStudentById(int id);
}
