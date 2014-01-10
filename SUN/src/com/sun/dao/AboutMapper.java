package com.sun.dao;

import com.sun.vo.About;
import com.sun.vo.AboutExample;
import com.sun.vo.AboutWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AboutMapper {
    int countByExample(AboutExample example);

    int deleteByExample(AboutExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AboutWithBLOBs record);

    int insertSelective(AboutWithBLOBs record);

    List<AboutWithBLOBs> selectByExampleWithBLOBs(AboutExample example);

    List<About> selectByExample(AboutExample example);

    AboutWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AboutWithBLOBs record, @Param("example") AboutExample example);

    int updateByExampleWithBLOBs(@Param("record") AboutWithBLOBs record, @Param("example") AboutExample example);

    int updateByExample(@Param("record") About record, @Param("example") AboutExample example);

    int updateByPrimaryKeySelective(AboutWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AboutWithBLOBs record);

    int updateByPrimaryKey(About record);
}