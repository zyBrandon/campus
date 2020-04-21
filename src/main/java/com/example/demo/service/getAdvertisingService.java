package com.example.demo.service;

import com.example.demo.mapper.getAdvertisingMapper;
import com.example.demo.model.Advertising;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class getAdvertisingService {

    @Autowired
    private getAdvertisingMapper getAdvertisingMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ArrayList<Advertising> getAdvertising(){
        ArrayList<Advertising> res = new ArrayList<Advertising>();
        //获取广告数据
        res = getAdvertisingMapper.getAdvertising();
        if (res == null){
            logger.warn("getAdvertising方法 获取广告数据异常");
        }
        return res;


    }
}
