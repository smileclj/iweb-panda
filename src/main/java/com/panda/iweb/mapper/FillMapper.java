package com.panda.iweb.mapper;

import com.panda.iweb.entity.Fill;
import com.panda.iweb.entity.FillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FillMapper {
    int countByExample(FillExample example);

    int deleteByExample(FillExample example);

    int insert(Fill record);

    int insertSelective(Fill record);

    List<Fill> selectByExample(FillExample example);

    int updateByExampleSelective(@Param("record") Fill record, @Param("example") FillExample example);

    int updateByExample(@Param("record") Fill record, @Param("example") FillExample example);
}