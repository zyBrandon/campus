package com.example.demo.service;

import com.example.demo.mapper.getNewProductMapper;
import com.example.demo.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class getNewProductService {

    @Autowired
    private getNewProductMapper getNewProductMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ArrayList<Product> getNewProduct(int newNum){
        if (getParams(newNum) == false){
            logger.warn("getNewProduct方法参数");
            return null;
        }

        ArrayList<Product> products = getNewProductMapper.getNewProduct(newNum);
        if (products == null){
            logger.warn("getNewProduct获取最新数据失败");
            return null;
        }

        return products;


    }

    public boolean getParams(int newNum){
        if (newNum < 0){
            return false;
        }

        return true;
    }
}
