package com.sun.dao;

import com.sun.vo.SysRoleExample;
import com.sun.vo.SysRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMapper {
    int countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(SysRoleKey key);

    int insert(SysRoleKey record);

    int insertSelective(SysRoleKey record);

    List<SysRoleKey> selectByExample(SysRoleExample example);

    int updateByExampleSelective(@Param("record") SysRoleKey record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRoleKey record, @Param("example") SysRoleExample example);
}