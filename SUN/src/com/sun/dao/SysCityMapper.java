package com.sun.dao;

import com.sun.vo.SysCity;
import com.sun.vo.SysCityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCityMapper {
    int countByExample(SysCityExample example);

    int deleteByExample(SysCityExample example);

    int deleteByPrimaryKey(Integer cityid);

    int insert(SysCity record);

    int insertSelective(SysCity record);

    List<SysCity> selectByExample(SysCityExample example);

    SysCity selectByPrimaryKey(Integer cityid);

    int updateByExampleSelective(@Param("record") SysCity record, @Param("example") SysCityExample example);

    int updateByExample(@Param("record") SysCity record, @Param("example") SysCityExample example);

    int updateByPrimaryKeySelective(SysCity record);

    int updateByPrimaryKey(SysCity record);
}