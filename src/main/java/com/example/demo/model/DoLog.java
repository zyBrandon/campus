package com.example.demo.model;

import java.util.Date;

public class DoLog {
    public int log_id;
    public String nickName;
    public Date visit_time;

    public DoLog(){

    }

    public DoLog(int log_id,String nickName,Date visit_time){
        this.log_id = log_id;
        this.nickName = nickName;
        this.visit_time = visit_time;
    }

    public Date getVisit_time() {
        return visit_time;
    }



    public int getLog_id() {
        return log_id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setVisit_time(Date visit_time) {
        this.visit_time = visit_time;
    }



    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
