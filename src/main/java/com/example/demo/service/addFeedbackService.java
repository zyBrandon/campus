package com.example.demo.service;

import com.example.demo.mapper.addFeedbackMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class addFeedbackService {

    @Autowired
    private addFeedbackMapper addFeedbackMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean addFeedback(String feedback_user,String feedback_title,String feedback_content){
        if (getParams(feedback_user, feedback_title, feedback_content) == false){
            logger.warn("addFeedback方法参数错误");
            return false;
        }

        Date feedback_time = new Date();
        int res = addFeedbackMapper.addFeedback(feedback_user,feedback_title,feedback_content,feedback_time);
        if (res == 0){
            logger.warn("添加数据失败");
            return false;
        }

        return true;

    }

    public boolean getParams(String feedback_user,String feedback_title,String feedback_content){
        if (feedback_user == null || feedback_title == null || feedback_content == null){
            return false;
        }

        return true;
    }
}
