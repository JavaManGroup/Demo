package com.sun.dao;

import com.sun.vo.Culture;
import com.sun.vo.CultureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CultureMapper {
    int countByExample(CultureExample example);

    int deleteByExample(CultureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Culture record);

    int insertSelective(Culture record);

    List<Culture> selectByExampleWithBLOBs(CultureExample example);

    List<Culture> selectByExample(CultureExample example);

    Culture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Culture record, @Param("example") CultureExample example);

    int updateByExampleWithBLOBs(@Param("record") Culture record, @Param("example") CultureExample example);

    int updateByExample(@Param("record") Culture record, @Param("example") CultureExample example);

    int updateByPrimaryKeySelective(Culture record);

    int updateByPrimaryKeyWithBLOBs(Culture record);

    int updateByPrimaryKey(Culture record);
}