package com.lsl.mapper;

import java.util.List;

import com.lsl.po.Backup;
import com.lsl.po.BackupExample;
import org.apache.ibatis.annotations.Param;

public interface BackupMapper {
    int countByExample(BackupExample example);

    int deleteByExample(BackupExample example);

    int deleteByPrimaryKey(Integer backupid);

    int insert(Backup record);

    int insertSelective(Backup record);

    List<Backup> selectByExample(BackupExample example);

    Backup selectByPrimaryKey(Integer backupid);

    int updateByExampleSelective(@Param("record") Backup record, @Param("example") BackupExample example);

    int updateByExample(@Param("record") Backup record, @Param("example") BackupExample example);

    int updateByPrimaryKeySelective(Backup record);

    int updateByPrimaryKey(Backup record);
}