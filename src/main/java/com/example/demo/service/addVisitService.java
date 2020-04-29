package com.example.demo.service;

import com.example.demo.mapper.addVisitMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class addVisitService {

    @Autowired
    private addVisitMapper addVisitMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean addVisitService(int product_id,String visit_user){
        if (getParams(product_id) == false){
            logger.warn("addVisitService参数错误");
            return false;
        }

        Date date = new Date();

        int res = addVisitMapper.addVisit(product_id,visit_user,date);
        if (res == 0){
            logger.warn("addVisit方法增加记录错误");
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
