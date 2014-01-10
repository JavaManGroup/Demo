package com.sun.dao;

import com.sun.vo.ProjectHonour;
import com.sun.vo.ProjectHonourExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectHonourMapper {
    int countByExample(ProjectHonourExample example);

    int deleteByExample(ProjectHonourExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectHonour record);

    int insertSelective(ProjectHonour record);

    List<ProjectHonour> selectByExample(ProjectHonourExample example);

    ProjectHonour selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectHonour record, @Param("example") ProjectHonourExample example);

    int updateByExample(@Param("record") ProjectHonour record, @Param("example") ProjectHonourExample example);

    int updateByPrimaryKeySelective(ProjectHonour record);

    int updateByPrimaryKey(ProjectHonour record);
}