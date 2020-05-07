package com.example.demo.service;

import com.example.demo.mapper.deleteCartMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class deleteCartService {

    @Autowired
    private deleteCartMapper deleteCartMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean deleteCart(int product_id,String product_buy_username){
        if (getParams(product_buy_username, product_id) == false){
            logger.warn("deleteCart参数错误");
            return false;
        }

        int res = deleteCartMapper.deleteCart(product_id, product_buy_username);
        if (res == 0){
            logger.warn("deleteCart删除失败");
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
