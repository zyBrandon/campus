package com.example.demo.service;

import com.example.demo.mapper.addCartMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class addCartService {

    @Autowired
    private addCartMapper addCartMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean addCart(int product_id, String product_buy_username, Date product_buy_time){
        if (getParams(product_buy_username, product_id) == false){
            logger.warn("getHaveCartByProductIdAndUsername方法参数错误");
            return false;
        }
        int res = addCartMapper.addCart(product_id, product_buy_username, product_buy_time);
        if (res == 0){
            logger.warn("addCart接口插入数据异常");
            return false;
        }

        return true;


    }

    public boolean getParams(String product_buy_username,int product_id){
        if (product_buy_username.length() > 30 || product_buy_username == null || product_id < 0){
            return false;
        }

        return true;
    }
}
