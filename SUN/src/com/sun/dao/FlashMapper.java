package com.sun.dao;

import com.sun.vo.Flash;
import com.sun.vo.FlashExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlashMapper {
    int countByExample(FlashExample example);

    int deleteByExample(FlashExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Flash record);

    int insertSelective(Flash record);

    List<Flash> selectByExample(FlashExample example);

    Flash selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Flash record, @Param("example") FlashExample example);

    int updateByExample(@Param("record") Flash record, @Param("example") FlashExample example);

    int updateByPrimaryKeySelective(Flash record);

    int updateByPrimaryKey(Flash record);
}