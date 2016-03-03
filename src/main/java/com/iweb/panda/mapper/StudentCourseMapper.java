package com.iweb.panda.mapper;

import com.iweb.panda.entity.StudentCourse;
import com.iweb.panda.entity.StudentCourseExample;
import java.util.List;

public interface StudentCourseMapper {
    int countByExample(StudentCourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentCourse record);

    int insertSelective(StudentCourse record);

    List<StudentCourse> selectByExample(StudentCourseExample example);

    StudentCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentCourse record);

    int updateByPrimaryKey(StudentCourse record);
}