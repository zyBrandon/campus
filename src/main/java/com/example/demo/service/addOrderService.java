package com.example.demo.service;

import com.example.demo.mapper.addOrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class addOrderService {

    @Autowired
    private addOrderMapper addOrderMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean addOrder(String product_buy_username, int product_id, Date product_buy_time){
        if (getParams(product_buy_username, product_id) == false){
            logger.warn("addOrder方法参数错误");
            return false;
        }

        int res = addOrderMapper.addOrder(product_id, product_buy_username, product_buy_time);
        if (res == 0){
            logger.warn("addOrder方法添加订单失败");
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
