package com.panda.iweb.service.impl;

import com.panda.iweb.entity.Course;
import com.panda.iweb.entity.Student;
import com.panda.iweb.mapper.CourseMapperExt;
import com.panda.iweb.mapper.StudentMapperExt;
import com.panda.iweb.service.TestService;
import com.panda.iweb.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

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
    @Resource
    private MyTask myTask;

    @Override
    public void addStudent(Student student) {
        studentMapperExt.insertSelective(student);
    }

    @Override
    public void addStudent(Student student, boolean throwException) {
        studentMapperExt.insertSelective(student);
        if (throwException) {
            throw new RuntimeException("exception");
        }

    }

    @Override
    public void addCourse(Course course) {
        courseMapperExt.insertSelective(course);
    }

    @Override
    public void addCourse(Course course, boolean throwException) {
        courseMapperExt.insertSelective(course);
        if (throwException) {
            throw new RuntimeException("exception");
        }
    }

    @Override
    public void addStudentAndCourse(Student student, Course course, boolean throwException) {
        addStudent(student);
        try {
            addCourse(course);
        } catch (Exception e) {
            System.out.println("捕到异常");
        }
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

    @Override
    public void addLotsOfStudents() {
        int size = 2;
        CountDownLatch latch = new CountDownLatch(size);
        for (int i = 0; i < size; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        Student student = new Student();
                        student.setName("小美" + i);
                        student.setSex(1);
                        student.setCreateTime(new Date());
                        studentMapperExt.insertSelective(student);
                    }
                    latch.countDown();
                }
            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void addLotsOfStudents2() {
        int size = 2;
        CountDownLatch latch = new CountDownLatch(size);
        myTask.setLetch(latch);
        for (int i = 0; i < size; i++) {
            pool.execute(myTask);
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void batchInsert(int num) {
        for (int i = 0; i < num; i++) {
            Student s = new Student();
            s.setName("小明");
//            if (i == 1) {
//                s.setName(null);
//            }
//            try {
            studentMapperExt.insertSelective(s);
//            } catch (Exception e) {
//                System.out.println("第" + i + 1 + "行添加失败");
//            }
        }
    }

    @Override
    public void singleInsert() {
        Student s = new Student();
        s.setName("小明");
        studentMapperExt.insertSelective(s);
    }

    @Override
    public void sqlBatchInsert(int num) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Student s = new Student();
            s.setName("小明");
            students.add(s);
        }
        studentMapperExt.batchInsert(students);
    }

    @Override
    public void batchUpdate() {
        for (int i = 0; i < 10000; i++) {
            Student s = new Student();
            s.setId(i + 1);
            s.setName("小红");
            studentMapperExt.updateByPrimaryKeySelective(s);
        }
    }

    @Override
    public void sqlBatchUpdate() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Student s = new Student();
            s.setId(i + 1);
            s.setName("小张");
            students.add(s);
        }
        studentMapperExt.batchUpdate(students);
    }


}
