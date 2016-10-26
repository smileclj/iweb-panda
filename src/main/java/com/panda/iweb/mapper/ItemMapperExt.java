package com.panda.iweb.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMapperExt extends ItemMapper {
    int updateStock(@Param("id") int id);
}