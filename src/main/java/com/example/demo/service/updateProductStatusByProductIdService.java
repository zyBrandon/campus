package com.example.demo.service;

import com.example.demo.mapper.updateProductStatusByProductIdMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class updateProductStatusByProductIdService {

    @Autowired
    private updateProductStatusByProductIdMapper updateProductStatusByProductId;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean updateProductStatusByProductId(int product_id){
        if (getParams(product_id) == false){
            logger.warn("updateProductStatusByProductId方法参数错误");
            return false;
        }

        int res = updateProductStatusByProductId.updateProductStatusByProductId(product_id);
        if (res == 0){
            logger.warn("更新商品状态值错误");
            return false;
        }

        return true;

    }

    public boolean getParams(int product_id){
        if (product_id < 0){
            return false;
        }

        return true;
    }

}
