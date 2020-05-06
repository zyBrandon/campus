package com.example.demo.service;

import com.example.demo.mapper.addPointMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class addPointService {

    @Autowired
    private addPointMapper addPointMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean addPoint(String nickName){
        if (getParams(nickName) == false){
            logger.warn("addPoint方法参数错误");
            return false;
        }

        Date point_time = new Date();

        int res = addPointMapper.addPoint(nickName,point_time);
        if (res == 0){
            logger.warn("插入分数失败");
            return false;
        }

        return true;

    }

    public boolean getParams(String nickName){
        if (nickName == null || nickName.length() > 40){
            return false;
        }

        return true;
    }
}
