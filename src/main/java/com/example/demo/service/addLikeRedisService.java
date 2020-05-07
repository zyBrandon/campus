package com.example.demo.service;

import com.example.demo.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class addLikeRedisService {
    public static final String like = "like";
    private final static long time = 259200;//3天

    @Autowired
    private RedisUtil redisUtil;


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean addLikeRedis(String nickName,int product_id){
        if (getParams(nickName, product_id) == false){
            logger.warn("addLikeRedis参数错误");
            return false;
        }

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
        String nowTime = dateFormat.format( date );

        //添加key value
        boolean addKeyValue = redisUtil.set(String.valueOf(product_id),nickName+nowTime,time);
        if (addKeyValue == false){
            logger.warn("添加key values redis失败");
            return false;
        }

        long addInc = redisUtil.incr(String.valueOf(product_id)+like,1);

        return true;
    }

    public boolean getParams(String nickName,int product_id){
        if (nickName == null || nickName.length() > 40 || product_id < 0){
            return false;
        }

        return true;
    }
}
