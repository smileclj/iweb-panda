package com.panda.iweb.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.panda.iweb.entity.Student;

@Repository
public interface StudentMapperExt extends StudentMapper {
	Student findStudentByIdWithXLock(@Param("id") int id);

	Student findStudentById(@Param("id") int id);
}