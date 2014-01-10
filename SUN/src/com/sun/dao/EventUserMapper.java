package com.sun.dao;

import com.sun.vo.EventUser;
import com.sun.vo.EventUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventUserMapper {
    int countByExample(EventUserExample example);

    int deleteByExample(EventUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EventUser record);

    int insertSelective(EventUser record);

    List<EventUser> selectByExample(EventUserExample example);

    EventUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EventUser record, @Param("example") EventUserExample example);

    int updateByExample(@Param("record") EventUser record, @Param("example") EventUserExample example);

    int updateByPrimaryKeySelective(EventUser record);

    int updateByPrimaryKey(EventUser record);
}