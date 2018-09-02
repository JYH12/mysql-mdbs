package com.lsl.service;

import com.lsl.mapper.InstanceMapper;
import com.lsl.mapper.UserMapper;
import com.lsl.po.Instance;
import com.lsl.po.InstanceExample;
import com.lsl.po.User;
import com.lsl.po.UserExample;
import com.lsl.utils.EasyUIDataGridResult;
import com.lsl.utils.JsonUtil;
import com.lsl.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.List;
import java.util.UUID;

@Service
public class LoginService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private InstanceMapper instanceMapper;

    @Autowired
    private JedisCluster jedisCluster;

    public Message userLogin(String username,String password){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal(-1);

        if (users==null||users.size()==0){
            return  Message.ok(null,result);
        }
        User user = users.get(0);
        if (!user.getPassword().equals(password)){
            return Message.ok(null,result);
        }
        String token = UUID.randomUUID().toString();
        user.setPassword(null);
        jedisCluster.set(token,JsonUtil.objectToJson(user));
        jedisCluster.expire(token,1800);

        InstanceExample instanceExample = new InstanceExample();
        InstanceExample.Criteria instanceCriteria = instanceExample.createCriteria();
        instanceCriteria.andUseridEqualTo(user.getUserid());
        List<Instance> instances = instanceMapper.selectByExample(instanceExample);
        result.setTotal(instances.size());
        result.setRows(instances);

        return Message.ok(token,result);
    }
}
