package com.iweb.panda.mapper;

import com.iweb.panda.entity.UserDo;
import com.iweb.panda.entity.UserDoExample;
import java.util.List;

public interface UserDoMapper {
    int countByExample(UserDoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserDo record);

    int insertSelective(UserDo record);

    List<UserDo> selectByExampleWithBLOBs(UserDoExample example);

    List<UserDo> selectByExample(UserDoExample example);

    UserDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDo record);

    int updateByPrimaryKeyWithBLOBs(UserDo record);

    int updateByPrimaryKey(UserDo record);
}