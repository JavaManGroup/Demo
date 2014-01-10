package com.sun.dao;

import com.sun.vo.Honour;
import com.sun.vo.HonourExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HonourMapper {
    int countByExample(HonourExample example);

    int deleteByExample(HonourExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Honour record);

    int insertSelective(Honour record);

    List<Honour> selectByExample(HonourExample example);

    Honour selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Honour record, @Param("example") HonourExample example);

    int updateByExample(@Param("record") Honour record, @Param("example") HonourExample example);

    int updateByPrimaryKeySelective(Honour record);

    int updateByPrimaryKey(Honour record);
}