package com.sun.dao;

import com.sun.vo.SysNewsType;
import com.sun.vo.SysNewsTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNewsTypeMapper {
    int countByExample(SysNewsTypeExample example);

    int deleteByExample(SysNewsTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNewsType record);

    int insertSelective(SysNewsType record);

    List<SysNewsType> selectByExampleWithBLOBs(SysNewsTypeExample example);

    List<SysNewsType> selectByExample(SysNewsTypeExample example);

    SysNewsType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNewsType record, @Param("example") SysNewsTypeExample example);

    int updateByExampleWithBLOBs(@Param("record") SysNewsType record, @Param("example") SysNewsTypeExample example);

    int updateByExample(@Param("record") SysNewsType record, @Param("example") SysNewsTypeExample example);

    int updateByPrimaryKeySelective(SysNewsType record);

    int updateByPrimaryKeyWithBLOBs(SysNewsType record);

    int updateByPrimaryKey(SysNewsType record);
}