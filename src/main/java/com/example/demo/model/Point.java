package com.example.demo.model;

import java.util.Date;

public class Point {
    public int point_id;
    public String nickName;
    public Date point_time;

    public Point(){

    }

    public Point(int point_id,String nickName,Date point_time){
        this.point_id = point_id;
        this.nickName = nickName;
        this.point_time = point_time;
    }

    public String getNickName() {
        return nickName;
    }

    public int getPoint_id() {
        return point_id;
    }

    public Date getPoint_num() {
        return point_time;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setPoint_id(int point_id) {
        this.point_id = point_id;
    }

    public void setPoint_num(Date point_time) {
        this.point_time = point_time;
    }
}
