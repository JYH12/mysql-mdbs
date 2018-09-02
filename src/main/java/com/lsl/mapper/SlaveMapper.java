package com.lsl.mapper;

import java.util.List;

import com.lsl.po.Slave;
import com.lsl.po.SlaveExample;
import org.apache.ibatis.annotations.Param;

public interface SlaveMapper {
    int countByExample(SlaveExample example);

    int deleteByExample(SlaveExample example);

    int deleteByPrimaryKey(String host);

    int insert(Slave record);

    int insertSelective(Slave record);

    List<Slave> selectByExample(SlaveExample example);

    Slave selectByPrimaryKey(String host);

    int updateByExampleSelective(@Param("record") Slave record, @Param("example") SlaveExample example);

    int updateByExample(@Param("record") Slave record, @Param("example") SlaveExample example);

    int updateByPrimaryKeySelective(Slave record);

    int updateByPrimaryKey(Slave record);
}