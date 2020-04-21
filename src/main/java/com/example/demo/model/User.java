package com.example.demo.model;

public class User {
    public int user_id;
    public String user_name;
    public String user_pass;
    public String city;
    public String avatarUrl;
    public String phone_num;
    public String extra;

    public User(){

    }

    public User(int user_id,String user_name,String user_pass,String city,String avatarUrl,String phone_num,String extra){
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_pass = user_pass;
        this.city = city;
        this.avatarUrl = avatarUrl;
        this.phone_num = phone_num;
        this.extra = extra;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public String getExtra() {
        return extra;
    }

    public String getUser_name() {
        return user_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getCity() {
        return city;
    }

    public String getUser_pass() {
        return user_pass;
    }


}
