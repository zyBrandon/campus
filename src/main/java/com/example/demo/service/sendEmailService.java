package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class sendEmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public boolean sendEmail(String email_num,String email_title,String email_content){
        MimeMessage message = null;
        try {
            message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("1025854421@qq.com");
            helper.setTo(email_num);
            helper.setSubject(email_title);

            StringBuffer sb = new StringBuffer();
            sb.append(email_content);
            helper.setText(sb.toString(), true);
            //FileSystemResource fileSystemResource=new FileSystemResource(new File("D:\76678.pdf"))
            //helper.addAttachment("电子发票"，fileSystemResource);
            javaMailSender.send(message);



        } catch (MessagingException e) {
            e.printStackTrace();
            return false;

        }
        return true;
    }
}
