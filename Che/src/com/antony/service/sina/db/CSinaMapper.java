package com.antony.service.sina.db;

import com.antony.service.sina.vo.CSina;
import com.antony.service.sina.vo.CSinaExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CSinaMapper {
    int countByExample(CSinaExample example);

    int deleteByExample(CSinaExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(CSina record);

    int insertSelective(CSina record);

    List<CSina> selectByExample(CSinaExample example);

    CSina selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") CSina record, @Param("example") CSinaExample example);

    int updateByExample(@Param("record") CSina record, @Param("example") CSinaExample example);

    int updateByPrimaryKeySelective(CSina record);

    int updateByPrimaryKey(CSina record);

    int getNextId();
}