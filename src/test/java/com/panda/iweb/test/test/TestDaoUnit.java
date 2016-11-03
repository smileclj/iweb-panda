package com.panda.iweb.test.test;

import com.panda.iweb.entity.Fill;
import com.panda.iweb.entity.FillExample;
import com.panda.iweb.entity.Student;
import com.panda.iweb.mapper.CourseMapperExt;
import com.panda.iweb.mapper.FillMapperExt;
import com.panda.iweb.mapper.StudentMapperExt;
import com.panda.iweb.util.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestDaoUnit {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private StudentMapperExt studentMapperExt;
    @Resource
    private CourseMapperExt courseMapperExt;
    @Resource
    private FillMapperExt fillMapperExt;

    @Test
    public void addStudent() {
        Student student = new Student();
        student.setName("小张");
        student.setSex(1);
        student.setCreateTime(new Date());
        logger.info("result:{}", studentMapperExt.insertSelective(student));
        logger.info("id:{}", student.getId());
    }

    @Test
    public void testSelectMulti(){
        List<Student> students = studentMapperExt.selectMulti(1,20);
    }

    @Test
    public void getStudent() {
        Student student = studentMapperExt.findStudentById(1);
        logger.info(JsonUtil.toJsonString(student));
    }

    @Test
    public void fillzero() {
        FillExample e_fill = new FillExample();
        List<Fill> fills = fillMapperExt.selectByExample(e_fill);
        System.out.println(JsonUtil.toJsonString(fills));
    }

    @Test
    public void executeQuery() {
        String sql = "select * from student order by id desc";
        List<Map<String, Object>> students = studentMapperExt.executeQuery(sql);
    }

    @Test
    public void executeUpdate() {
        String sql = "update student set sex = 20 where id = 1";
        int count = studentMapperExt.executeUpdate(sql);
    }
}
