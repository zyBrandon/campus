package com.example.demo.service;

import com.example.demo.mapper.getHaveCartByProductIdAndUsernameMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class getHaveCartByProductIdAndUsernameService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private getHaveCartByProductIdAndUsernameMapper getHaveCartByProductIdAndUsernameMapper;

    public int getHaveCartByProductIdAndUsername(String product_buy_username,int product_id){
        if (getParams(product_buy_username, product_id) == false){
            logger.warn("getHaveCartByProductIdAndUsername方法参数错误");
            return 0;
        }

        int res = getHaveCartByProductIdAndUsernameMapper.getHaveCartByProductIdAndUsername(product_buy_username, product_id);
        return res;

    }
    public boolean getParams(String product_buy_username,int product_id){
        if (product_buy_username.length() > 30 || product_buy_username == null || product_id < 0){
            return false;
        }

        return true;
    }
}
