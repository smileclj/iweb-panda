package com.panda.iweb.mapper;

import com.panda.iweb.entity.Student;
import com.panda.iweb.entity.StudentExample;
import java.util.List;

public interface StudentMapper {
    int countByExample(StudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}