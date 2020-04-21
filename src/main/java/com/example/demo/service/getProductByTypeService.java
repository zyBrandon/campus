package com.example.demo.service;

import com.example.demo.mapper.getProductByTypeMapper;
import com.example.demo.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class getProductByTypeService {

    @Autowired
    private getProductByTypeMapper getProductByTypeMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ArrayList<Product> getProductByType(String type){
        if (getParams(type) == false){
            logger.warn("getProductByType接口参数异常");
            return null;
        }

        ArrayList<Product> res = getProductByTypeMapper.getProductByType(type);
        if (res == null){
            logger.warn("getProductByType获取type错误");
            return null;
        }

        return res;
    }

    public boolean getParams(String type){
        if (type == null || type.length() > 30){
            return false;
        }
        return true;
    }
}
