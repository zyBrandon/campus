package com.example.demo.service;

import com.example.demo.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class getLikeRedisService {

    public static final String like = "like";

    @Autowired
    private RedisUtil redisUtil;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public String getLikeRedis(String nickName){
        if (getParams(nickName) == false){
            logger.warn("参数错误");
            return null;
        }

        String res = (String)redisUtil.get(nickName+like);
        if (res == null){
            logger.warn("查询redis失败");
            return null;
        }

        return res;

    }

    public boolean getParams(String nickName){
        if (nickName == null || nickName.length() > 40){
            return false;
        }
        return true;
    }

}
