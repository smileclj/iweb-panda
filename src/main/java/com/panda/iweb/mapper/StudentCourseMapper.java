package com.panda.iweb.mapper;

import com.panda.iweb.entity.StudentCourse;
import com.panda.iweb.entity.StudentCourseExample;
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