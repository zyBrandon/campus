package com.example.demo.service;

import com.example.demo.mapper.addLikeDBMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class addLikeDBService {

    @Autowired
    private addLikeDBMapper addLikeDBMapper;


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean addLikeDBService(String nickName,int product_id){
        if (getParams(nickName, product_id) == false){
            logger.warn("添加db失败");
            return false;
        }

        Date like_time = new Date();

        int res = addLikeDBMapper.addLikeDB(nickName,product_id,like_time);
        if (res == 0){
            logger.warn("添加入库失败");
            return false;
        }
        return true;

    }

    public boolean getParams(String nickName,int product_id){
        if (nickName == null || nickName.length() > 40 || product_id < 0){
            return false;
        }

        return true;
    }

}
