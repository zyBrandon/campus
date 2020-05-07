package com.example.demo.service;

import com.example.demo.mapper.getProductByNameMapper;
import com.example.demo.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class getProductByNameService {

    @Autowired
    private getProductByNameMapper getProductByNameMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ArrayList<Product> getProductByName(String name){
        if (getParams(name) == false){
            logger.warn("getProductByName参数错误");
            return null;
        }

        ArrayList<Product> products = getProductByNameMapper.getProductByName(name);
        if (products == null){
            logger.warn("数据为空");
            return null;
        }

        return products;
    }

    public boolean getParams(String name){
        if (name == null){
            return false;
        }
        return true;
    }
}
