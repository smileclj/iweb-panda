package com.panda.iweb.test.test;

import com.panda.iweb.entity.Course;
import com.panda.iweb.entity.Student;
import com.panda.iweb.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        course.setName("养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生养生1");
        course.setCreateTime(new Date());

        try {
            testService.addStudentAndCourse(student, course, true);
            // testService.addStudent(student, true);
        } catch (Exception e) {
            e.printStackTrace();
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
        for (int i = 0; i < 1000; i++) {
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

    @Test
    public void batchInsert() {
        long start = System.currentTimeMillis();
        testService.batchInsert(1000);
        long end = System.currentTimeMillis();
        System.out.println("batchInsert耗时：" + (end - start) + "ms");
    }

    @Test
    public void batchInsert2() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Student s = new Student();
            s.setName("小明");
            students.add(s);
        }
        long start = System.currentTimeMillis();
        testService.batchInsert(students);
        long end = System.currentTimeMillis();
        System.out.println("batchInsert耗时：" + (end - start) + "ms");
    }

    @Test
    //耗时:3292毫秒
    public void batchUpdate() {
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Student student = new Student();
            student.setId(i);
            student.setName("小cui");
            if (i == 4) {
                student.setSex(256);
            }
            students.add(student);
        }
        long start = System.currentTimeMillis();
        int row = testService.batchUpdate(students);
        long end = System.currentTimeMillis();
        System.out.println(row);
        System.out.println("耗时:" + (end - start) + "毫秒");
    }

    @Test
    public void update() {
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Student student = new Student();
            student.setId(i);
            student.setName("小猪");
            students.add(student);
        }
        long start = System.currentTimeMillis();
        for (Student student : students) {
            testService.update(student);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start) + "毫秒");
    }

    @Test
    public void batchUpdateMultiThread() {
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            Student student = new Student();
            student.setId(i);
            student.setName("小林");
            students.add(student);
        }
        long start = System.currentTimeMillis();
        testService.batchUpdateMultiThread(students);
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start) + "毫秒");
    }

    @Test
    public void testAutoLock() {
        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":" + testService.updateItemStock(1));
                }
            });
            t.start();
        }
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
