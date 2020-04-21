package com.example.demo.model;

public class Admin {
    public int admin_id;
    public String admin_name;
    public String admin_pass;
    public String phone_num;
    public String email;
    public String extra;

    public Admin(int admin_id,String admin_name,String admin_pass,String phone_num,String email,String extra){
        this.admin_id = admin_id;
        this.admin_name = admin_name;
        this.admin_pass = admin_pass;
        this.phone_num = phone_num;
        this.email = email;
        this.extra = extra;
    }

    public Admin(){

    }

    public String getEmail() {
        return email;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public String getAdmin_pass() {
        return admin_pass;
    }

    public String getExtra() {
        return extra;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public void setAdmin_pass(String admin_pass) {
        this.admin_pass = admin_pass;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }


}
