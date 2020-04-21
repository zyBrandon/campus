package com.example.demo.model;

public class Order {
    public int order_id;
    public int product_id;
    public String product_buy_username;
    public String product_buy_time;
    public int product_buy_count;
    public String order_status;

    public Order(){

    }

    public Order(int order_id,int product_id,String product_buy_username,String product_buy_time,int product_buy_count,String order_status){
        this.order_id = order_id;
        this.product_id = product_id;
        this.product_buy_username = product_buy_username;
        this.product_buy_time = product_buy_time;
        this.product_buy_count = product_buy_count;
        this.order_status = order_status;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getProduct_buy_count() {
        return product_buy_count;
    }

    public String getOrder_status() {
        return order_status;
    }

    public String getProduct_buy_time() {
        return product_buy_time;
    }

    public String getProduct_buy_username() {
        return product_buy_username;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public void setProduct_buy_count(int product_buy_count) {
        this.product_buy_count = product_buy_count;
    }

    public void setProduct_buy_time(String product_buy_time) {
        this.product_buy_time = product_buy_time;
    }

    public void setProduct_buy_username(String product_buy_username) {
        this.product_buy_username = product_buy_username;
    }

}
