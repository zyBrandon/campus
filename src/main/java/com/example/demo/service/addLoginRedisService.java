package com.example.demo.service;

import com.example.demo.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class addLoginRedisService {

    private final static String land = "land";
    private final static long time = 2000;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisUtil redisUtil;

    public boolean addLoginRedis(String nickName){
        //入redis
        boolean res = redisUtil.set(nickName,land,time);
        if (res == true){
            return true;
        } else {
            logger.warn("addUsernameRedis添加redis失败");
            return false;
        }
    }

}
