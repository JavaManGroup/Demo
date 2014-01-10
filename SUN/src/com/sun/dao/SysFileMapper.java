package com.sun.dao;

import com.sun.vo.SysFile;
import com.sun.vo.SysFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysFileMapper {
    int countByExample(SysFileExample example);

    int deleteByExample(SysFileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysFile record);

    int insertSelective(SysFile record);

    List<SysFile> selectByExample(SysFileExample example);

    SysFile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysFile record, @Param("example") SysFileExample example);

    int updateByExample(@Param("record") SysFile record, @Param("example") SysFileExample example);

    int updateByPrimaryKeySelective(SysFile record);

    int updateByPrimaryKey(SysFile record);
}