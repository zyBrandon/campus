package com.example.demo.service;

import com.example.demo.mapper.getProductByProductIdMapper;
import com.example.demo.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class getProductByProductIdService {

    @Autowired
    private getProductByProductIdMapper getProductByProductIdMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Product getProductByProductId(int product_id){

        if (getParams(product_id) == false){
            logger.warn("getProductByProductId方法参数错误");
            return null;
        }

        Product product = getProductByProductIdMapper.getProductByProductId(product_id);

        return product;
    }

    public boolean getParams(int product_id){
        if (product_id < 0){
            return false;
        }
        return true;
    }
}
