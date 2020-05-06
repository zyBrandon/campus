package com.example.demo.model;

import java.util.Date;

public class Admin_Email {
    public int email_id;
    public String email_num;
    public String email_title;
    public String email_content;
    public Date email_time;

    public Admin_Email(){

    }

    public Admin_Email(int email_id,String email_num,String email_title,String email_content,Date email_time){
        this.email_id = email_id;
        this.email_num = email_num;
        this.email_title = email_title;
        this.email_content = email_content;
        this.email_time = email_time;
    }

    public Date getEmail_time() {
        return email_time;
    }

    public int getEmail_id() {
        return email_id;
    }

    public String getEmail_content() {
        return email_content;
    }

    public String getEmail_num() {
        return email_num;
    }

    public String getEmail_title() {
        return email_title;
    }

    public void setEmail_content(String email_content) {
        this.email_content = email_content;
    }

    public void setEmail_id(int email_id) {
        this.email_id = email_id;
    }

    public void setEmail_num(String email_num) {
        this.email_num = email_num;
    }

    public void setEmail_time(Date email_time) {
        this.email_time = email_time;
    }

    public void setEmail_title(String email_title) {
        this.email_title = email_title;
    }
}
