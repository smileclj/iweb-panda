package com.panda.iweb.service;

import com.panda.iweb.entity.Course;
import com.panda.iweb.entity.Student;

import java.util.List;

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

    void batchInsert(int num);

    //==============//

    int insert(Student student);

    int batchInsert(List<Student> students);

    int update(Student student);

    int batchUpdate(List<Student> students);

    void batchUpdateMultiThread(List<Student> students);

    List<Integer> batchUpdateInner(List<Student> students);

    int updateItemStock(int id);
}
