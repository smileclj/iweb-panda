package com.panda.iweb.service;

import com.panda.iweb.entity.Course;
import com.panda.iweb.entity.Student;

public interface TestService {
	void addStudent(Student student);

	void addStudent(Student student, boolean throwException);

	void addCourse(Course course);

	void addCourse(Course course, boolean throwException);

	void addStudentAndCourse(Student student, Course course, boolean throwException);

	void getAddStudentAndCourse(Student student, Course course, boolean throwException);

	void getStudentById(int id);

	void getStudentByIdWithSync(int id);

	void testThreadXLock();

	void addLotsOfStudents();

	void addLotsOfStudents2();
}
