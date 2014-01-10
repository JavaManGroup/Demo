package com.sun.dao;

import com.sun.vo.ProjectType;
import com.sun.vo.ProjectTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectTypeMapper {
    int countByExample(ProjectTypeExample example);

    int deleteByExample(ProjectTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectType record);

    int insertSelective(ProjectType record);

    List<ProjectType> selectByExample(ProjectTypeExample example);

    ProjectType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectType record, @Param("example") ProjectTypeExample example);

    int updateByExample(@Param("record") ProjectType record, @Param("example") ProjectTypeExample example);

    int updateByPrimaryKeySelective(ProjectType record);

    int updateByPrimaryKey(ProjectType record);
}