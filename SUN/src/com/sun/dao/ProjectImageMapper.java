package com.sun.dao;

import com.sun.vo.ProjectImage;
import com.sun.vo.ProjectImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectImageMapper {
    int countByExample(ProjectImageExample example);

    int deleteByExample(ProjectImageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectImage record);

    int insertSelective(ProjectImage record);

    List<ProjectImage> selectByExample(ProjectImageExample example);

    ProjectImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectImage record, @Param("example") ProjectImageExample example);

    int updateByExample(@Param("record") ProjectImage record, @Param("example") ProjectImageExample example);

    int updateByPrimaryKeySelective(ProjectImage record);

    int updateByPrimaryKey(ProjectImage record);
}