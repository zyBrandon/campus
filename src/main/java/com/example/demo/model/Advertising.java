package com.example.demo.model;

public class Advertising {
    public int advertising_id;
    public String img_url;
    public String recommend_time;
    public String name;

    public Advertising(){

    }

    public Advertising(int advertising_id,String img_url,String recommend_time,String name){
        this.advertising_id = advertising_id;
        this.img_url = img_url;
        this.recommend_time = recommend_time;
        this.name = name;
    }

    public int getAdvertising_id() {
        return advertising_id;
    }

    public String getImg_url() {
        return img_url;
    }

    public String getRecommend_time() {
        return recommend_time;
    }

    public String getName() {
        return name;
    }

    public void setAdvertising_id(int advertising_id) {
        this.advertising_id = advertising_id;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public void setRecommend_time(String recommend_time) {
        this.recommend_time = recommend_time;
    }

    public void setName(String name) {
        this.name = name;
    }
}
