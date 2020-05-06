package com.example.demo.service;

import com.example.demo.mapper.getAllLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class getAllLogService {

    @Autowired
    private getAllLogMapper getAllLogMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public int getAllLogService(){

        int res = getAllLogMapper.getAllLog();

        return res;
    }
}
