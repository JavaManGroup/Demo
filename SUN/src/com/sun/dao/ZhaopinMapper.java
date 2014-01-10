package com.sun.dao;

import com.sun.vo.Zhaopin;
import com.sun.vo.ZhaopinExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZhaopinMapper {
    int countByExample(ZhaopinExample example);

    int deleteByExample(ZhaopinExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Zhaopin record);

    int insertSelective(Zhaopin record);

    List<Zhaopin> selectByExampleWithBLOBs(ZhaopinExample example);

    List<Zhaopin> selectByExample(ZhaopinExample example);

    Zhaopin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Zhaopin record, @Param("example") ZhaopinExample example);

    int updateByExampleWithBLOBs(@Param("record") Zhaopin record, @Param("example") ZhaopinExample example);

    int updateByExample(@Param("record") Zhaopin record, @Param("example") ZhaopinExample example);

    int updateByPrimaryKeySelective(Zhaopin record);

    int updateByPrimaryKeyWithBLOBs(Zhaopin record);

    int updateByPrimaryKey(Zhaopin record);
}