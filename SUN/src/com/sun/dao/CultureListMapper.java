package com.sun.dao;

import com.sun.vo.CultureList;
import com.sun.vo.CultureListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CultureListMapper {
    int countByExample(CultureListExample example);

    int deleteByExample(CultureListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CultureList record);

    int insertSelective(CultureList record);

    List<CultureList> selectByExampleWithBLOBs(CultureListExample example);

    List<CultureList> selectByExample(CultureListExample example);

    CultureList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CultureList record, @Param("example") CultureListExample example);

    int updateByExampleWithBLOBs(@Param("record") CultureList record, @Param("example") CultureListExample example);

    int updateByExample(@Param("record") CultureList record, @Param("example") CultureListExample example);

    int updateByPrimaryKeySelective(CultureList record);

    int updateByPrimaryKeyWithBLOBs(CultureList record);

    int updateByPrimaryKey(CultureList record);
}