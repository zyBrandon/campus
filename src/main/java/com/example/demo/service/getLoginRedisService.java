package com.example.demo.service;

import com.example.demo.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class getLoginRedisService {

    private final static String land = "land";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisUtil redisUtil;

    public boolean getUserLand(String nickName){
        if (getParams(nickName) == false){
            logger.warn("getUserLand方法username返回false");
            return false;
        }

        String res = (String)redisUtil.get(nickName);
        logger.warn("----------redis获取到的数值为"+res);
        if (res != null){
            if (res.equals(land)){
                return true;
            }
        }


        return false;
    }

    public boolean getParams(String username){
        if (null == username || username.length() > 20){
            return false;
        }
        return true;
    }

}
