package com.example.demo.model;

import java.util.Date;

public class Product {
    public int product_id;
    public String product_sell_user;
    public String product_name;
    public String product_type;
    public String product_describe;
    public int product_price;
    public Date product_release_time;
    public Date product_end_time;
    public String product_image_url;

    public Product(int product_id,String product_sell_user,String product_name,String product_type,String product_describe,int product_price,
                   Date product_release_time,Date product_end_time,String product_image_url){
        this.product_id = product_id;
        this.product_sell_user = product_sell_user;
        this.product_name = product_name;
        this.product_type = product_type;
        this.product_describe = product_describe;
        this.product_price = product_price;
        this.product_release_time = product_release_time;
        this.product_end_time = product_end_time;
        this.product_image_url = product_image_url;
    }

    public Product(){

    }

    public int getProduct_id() {
        return product_id;
    }

    public int getProduct_price() {
        return product_price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_describe() {
        return product_describe;
    }

    public Date getProduct_release_time() {
        return product_release_time;
    }

    public String getProduct_sell_user() {
        return product_sell_user;
    }

    public String getProduct_type() {
        return product_type;
    }

    public Date getProduct_end_time() {
        return product_end_time;
    }

    public String getProduct_image_url() {
        return product_image_url;
    }

    public void setProduct_describe(String product_describe) {
        this.product_describe = product_describe;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public void setProduct_release_time(Date product_release_time) {
        this.product_release_time = product_release_time;
    }

    public void setProduct_sell_user(String product_sell_user) {
        this.product_sell_user = product_sell_user;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public void setProduct_end_time(Date product_end_time) {
        this.product_end_time = product_end_time;
    }

    public void setProduct_image_url(String product_image_url) {
        this.product_image_url = product_image_url;
    }
}
