package com.example.demo.model;

import java.util.Date;

public class Like {
    public int like_id;
    public String nickName;
    public int product_id;
    public Date like_time;

    public Like(){

    }

    public Like(int like_id,String nickName,int product_id,Date like_time){
        this.like_id = like_id;
        this.nickName = nickName;
        this.product_id = product_id;
        this.like_time = like_time;
    }

    public String getNickName() {
        return nickName;
    }

    public int getProduct_id() {
        return product_id;
    }

    public Date getLike_time() {
        return like_time;
    }

    public int getLike_id() {
        return like_id;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setLike_id(int like_id) {
        this.like_id = like_id;
    }

    public void setLike_time(Date like_time) {
        this.like_time = like_time;
    }
}
