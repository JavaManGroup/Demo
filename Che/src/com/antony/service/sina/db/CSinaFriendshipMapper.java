package com.antony.service.sina.db;

import com.antony.service.sina.vo.CSinaFriendship;
import com.antony.service.sina.vo.CSinaFriendshipExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CSinaFriendshipMapper {
    int countByExample(CSinaFriendshipExample example);

    int deleteByExample(CSinaFriendshipExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(CSinaFriendship record);

    int insertSelective(CSinaFriendship record);

    List<CSinaFriendship> selectByExample(CSinaFriendshipExample example);

    CSinaFriendship selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") CSinaFriendship record, @Param("example") CSinaFriendshipExample example);

    int updateByExample(@Param("record") CSinaFriendship record, @Param("example") CSinaFriendshipExample example);

    int updateByPrimaryKeySelective(CSinaFriendship record);

    int updateByPrimaryKey(CSinaFriendship record);

    int getNextId();
}