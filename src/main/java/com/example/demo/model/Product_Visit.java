package com.example.demo.model;

import java.util.Date;

public class Product_Visit {
    public int product_visit_id;
    public int product_id;
    public Date visit_time;
    public String visit_user;

    public Product_Visit(){

    }

    public Product_Visit(int product_visit_id,int product_id,Date visit_time,String visit_user){
        this.product_visit_id = product_visit_id;
        this.product_id = product_id;
        this.visit_time = visit_time;
        this.visit_user = visit_user;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setProduct_visit_id(int product_visit_id) {
        this.product_visit_id = product_visit_id;
    }



    public void setVisit_time(Date visit_time) {
        this.visit_time = visit_time;
    }

    public void setVisit_user(String visit_user) {
        this.visit_user = visit_user;
    }

    public int getProduct_visit_id() {
        return product_visit_id;
    }



    public int getProduct_id() {
        return product_id;
    }

    public Date getVisit_time() {
        return visit_time;
    }

    public String getVisit_user() {
        return visit_user;
    }
}
