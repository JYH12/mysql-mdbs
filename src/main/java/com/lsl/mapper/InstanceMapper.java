package com.lsl.mapper;

import java.util.List;

import com.lsl.po.Instance;
import com.lsl.po.InstanceExample;
import org.apache.ibatis.annotations.Param;

public interface InstanceMapper {
    int countByExample(InstanceExample example);

    int deleteByExample(InstanceExample example);

    int deleteByPrimaryKey(Integer instanceid);

    int insert(Instance record);

    int insertSelective(Instance record);

    List<Instance> selectByExample(InstanceExample example);

    Instance selectByPrimaryKey(Integer instanceid);

    int updateByExampleSelective(@Param("record") Instance record, @Param("example") InstanceExample example);

    int updateByExample(@Param("record") Instance record, @Param("example") InstanceExample example);

    int updateByPrimaryKeySelective(Instance record);

    int updateByPrimaryKey(Instance record);
}