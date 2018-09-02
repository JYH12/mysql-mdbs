package com.lsl.mapper;

import java.util.List;

import com.lsl.po.HostInfo;
import com.lsl.po.HostInfoExample;
import org.apache.ibatis.annotations.Param;

public interface HostInfoMapper {
    int countByExample(HostInfoExample example);

    int deleteByExample(HostInfoExample example);

    int deleteByPrimaryKey(String host);

    int insert(HostInfo record);

    int insertSelective(HostInfo record);

    List<HostInfo> selectByExample(HostInfoExample example);

    HostInfo selectByPrimaryKey(String host);

    int updateByExampleSelective(@Param("record") HostInfo record, @Param("example") HostInfoExample example);

    int updateByExample(@Param("record") HostInfo record, @Param("example") HostInfoExample example);

    int updateByPrimaryKeySelective(HostInfo record);

    int updateByPrimaryKey(HostInfo record);
}