package com.example.demo.controller;

import com.example.demo.service.addEmailService;
import com.example.demo.service.sendEmailService;
import com.example.demo.util.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class SendEmailController {

    public static final String addEmail = "addEmail";
    public static final String success = "success";

    @Autowired
    private sendEmailService sendEmailService;

    @Autowired
    private addEmailService addEmailService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/sendemail",method = RequestMethod.GET)
    public ApiResult sendemail(@RequestParam("email_num") String email_num,@RequestParam("email_title") String email_title,@RequestParam("email_content") String email_content){
        HashMap res = new HashMap();

        //发送邮件
        boolean sendEmaildRes = sendEmailService.sendEmail(email_num, email_title, email_content);
        if (sendEmaildRes == false){
            logger.warn("发送邮件失败");
            return ApiResult.success(20001,"发送邮件失败","");
        }

        //发送邮件内容入库
        boolean addEmailRes = addEmailService.addEmail(email_num, email_title, email_content);
        if (addEmailRes == false){
            logger.warn("发送邮件入库失败");
            return ApiResult.success(20001,"发送邮件入库失败","");
        }

        res.put(addEmail,success);

        return ApiResult.success(200,"success",res);
    }
}
