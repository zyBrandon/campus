package com.example.demo.service;

import com.example.demo.mapper.getProductBySellNameMapper;
import com.example.demo.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class getProductBySellNameService {

    @Autowired
    private getProductBySellNameMapper getProductBySellNameMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ArrayList<Product> getProductBySellName(String product_sell_user){
        if (getParams(product_sell_user) == false){
            logger.warn("getProductBySellName方法错误");
            return null;
        }

        ArrayList<Product> productList = getProductBySellNameMapper.getProductBySellName(product_sell_user);
        if (productList == null){
            logger.warn("getProductBySellName获取出售商品为空");
        }

        return productList;

    }

    public boolean getParams(String product_sell_user){
        if (product_sell_user == null || product_sell_user.length() > 40){
            return false;
        }

        return true;
    }

}
