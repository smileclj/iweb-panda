package com.panda.iweb.mapper;

import com.panda.iweb.entity.Course;
import com.panda.iweb.entity.CourseExample;
import java.util.List;

public interface CourseMapper {
    int countByExample(CourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}