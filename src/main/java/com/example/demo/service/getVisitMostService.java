package com.example.demo.service;

import com.example.demo.mapper.getVisitMostMapper;
import com.example.demo.model.Product_Visit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class getVisitMostService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public getVisitMostMapper getVisitMostMapper;

    public ArrayList<Integer> getVisitMost(int hotcount){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (getParams(hotcount) == false){
            logger.warn("getVisitMost方法hotcount错误");
            return res;
        }

        //获取访问最多的数据列表
        res = getVisitMostMapper.getVisitMost(hotcount);
        if (res == null){
            logger.warn("getVisitMost方法获取热度错误");
            return res;
        }



        return res;

    }

    public boolean getParams(int hotcount){
        if (hotcount < 0){
            return false;
        }

        return true;
    }
}
