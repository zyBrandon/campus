package com.example.demo.service;

import com.example.demo.mapper.addProductMapper;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class addProductService {

    @Autowired
    private addProductMapper addProductMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean addProduct(String product_sell_user,String product_name,String product_type,String product_describe,int product_price,String product_image_url){
        if (getParams(product_sell_user, product_name, product_type, product_describe, product_price, product_image_url) == false){
            logger.warn("addProduct方法参数错误");
            return false;
        }
        Date date = new Date();
        int res = addProductMapper.addProduct(product_sell_user,product_name, product_type,product_describe, product_price,date, product_image_url);
        if (res == 0){
            logger.warn("addProduct接口添加数据失败");
            return false;
        }
        return true;
    }

    public boolean getParams(String product_sell_user,String product_name,String product_type,String product_describe,int product_price,String product_image_url){
        if (product_sell_user == null || product_name == null || product_type ==null || product_describe == null || product_price < 0 || product_image_url == null){
            return false;
        }

        return true;
    }
}
