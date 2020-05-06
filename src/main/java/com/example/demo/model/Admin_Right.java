package com.example.demo.model;

public class Admin_Right {
    public int admin_right_id;
    public String admin_name;
    public String right_name;

    public Admin_Right(){

    }

    public Admin_Right(int admin_right_id,String admin_name,String right_name){
        this.admin_right_id = admin_right_id;
        this.admin_name = admin_name;
        this.right_name = right_name;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public int getAdmin_right_id() {
        return admin_right_id;
    }

    public String getRight_name() {
        return right_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public void setAdmin_right_id(int admin_right_id) {
        this.admin_right_id = admin_right_id;
    }

    public void setRight_name(String right_name) {
        this.right_name = right_name;
    }
}
