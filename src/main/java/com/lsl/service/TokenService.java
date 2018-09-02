package com.lsl.service;

import com.lsl.po.User;
import com.lsl.utils.JsonUtil;
import com.lsl.utils.Message;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

@Service
public class TokenService {
    @Autowired
    private JedisCluster jedisCluster;

    public Message getUserByToken(String token){
        String json= jedisCluster.get(token);
        if (StringUtils.isBlank(json)){
            return Message.build("用户登录过期",204);
        }
        jedisCluster.expire(token,1800);
        User user = JsonUtil.jsonToPojo(json, User.class);
        return Message.ok(user);
    }
}
