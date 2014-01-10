package com.sun.dao;

import com.sun.vo.SysProvince;
import com.sun.vo.SysProvinceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysProvinceMapper {
    int countByExample(SysProvinceExample example);

    int deleteByExample(SysProvinceExample example);

    int deleteByPrimaryKey(Integer proid);

    int insert(SysProvince record);

    int insertSelective(SysProvince record);

    List<SysProvince> selectByExample(SysProvinceExample example);

    SysProvince selectByPrimaryKey(Integer proid);

    int updateByExampleSelective(@Param("record") SysProvince record, @Param("example") SysProvinceExample example);

    int updateByExample(@Param("record") SysProvince record, @Param("example") SysProvinceExample example);

    int updateByPrimaryKeySelective(SysProvince record);

    int updateByPrimaryKey(SysProvince record);
}