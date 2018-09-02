package com.lsl.mapper;

import java.util.List;

import com.lsl.po.DatabaseInfo;
import com.lsl.po.DatabaseInfoExample;
import org.apache.ibatis.annotations.Param;

public interface DatabaseInfoMapper {
    int countByExample(DatabaseInfoExample example);

    int deleteByExample(DatabaseInfoExample example);

    int deleteByPrimaryKey(Integer databaseid);

    int insert(DatabaseInfo record);

    int insertSelective(DatabaseInfo record);

    List<DatabaseInfo> selectByExample(DatabaseInfoExample example);

    DatabaseInfo selectByPrimaryKey(Integer databaseid);

    int updateByExampleSelective(@Param("record") DatabaseInfo record, @Param("example") DatabaseInfoExample example);

    int updateByExample(@Param("record") DatabaseInfo record, @Param("example") DatabaseInfoExample example);

    int updateByPrimaryKeySelective(DatabaseInfo record);

    int updateByPrimaryKey(DatabaseInfo record);
}