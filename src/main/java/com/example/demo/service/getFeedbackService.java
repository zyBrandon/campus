package com.example.demo.service;

import com.example.demo.mapper.getFeedbackMapper;
import com.example.demo.model.Feedback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class getFeedbackService {

    @Autowired
    private getFeedbackMapper getFeedbackMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ArrayList<Feedback> getFeedback(){
        ArrayList<Feedback> res = getFeedbackMapper.getFeedback();

        if (res == null){
            logger.warn("反馈为空");
            return null;
        }

        return res;
    }
}
