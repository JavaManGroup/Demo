package com.sun.dao;

import com.sun.vo.SysGroup;
import com.sun.vo.SysGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysGroupMapper {
    int countByExample(SysGroupExample example);

    int deleteByExample(SysGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysGroup record);

    int insertSelective(SysGroup record);

    List<SysGroup> selectByExample(SysGroupExample example);

    SysGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysGroup record, @Param("example") SysGroupExample example);

    int updateByExample(@Param("record") SysGroup record, @Param("example") SysGroupExample example);

    int updateByPrimaryKeySelective(SysGroup record);

    int updateByPrimaryKey(SysGroup record);
}