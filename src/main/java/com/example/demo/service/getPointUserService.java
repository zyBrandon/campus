package com.example.demo.service;

import com.example.demo.mapper.getPointUserMapper;
import com.example.demo.model.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class getPointUserService {

    @Autowired
    private getPointUserMapper getPointUserMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ArrayList<Point> getPointUser(){
        ArrayList<Point> res = getPointUserMapper.getPointUser();
        if (res == null){
            logger.warn("getPointUser方法查询数据为空");
            return null;
        }
        return res;
    }

}
