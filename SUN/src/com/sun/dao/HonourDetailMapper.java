package com.sun.dao;

import com.sun.vo.HonourDetail;
import com.sun.vo.HonourDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HonourDetailMapper {
    int countByExample(HonourDetailExample example);

    int deleteByExample(HonourDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HonourDetail record);

    int insertSelective(HonourDetail record);

    List<HonourDetail> selectByExample(HonourDetailExample example);

    HonourDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HonourDetail record, @Param("example") HonourDetailExample example);

    int updateByExample(@Param("record") HonourDetail record, @Param("example") HonourDetailExample example);

    int updateByPrimaryKeySelective(HonourDetail record);

    int updateByPrimaryKey(HonourDetail record);
}