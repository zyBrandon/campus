package com.example.demo.model;

public class Shopping_Cart {
    public int shopping_cart_id;
    public int product_id;
    public String product_buy_username;
    public String product_buy_time;
    public String product_buy_count;

    public Shopping_Cart(){

    }

    public Shopping_Cart(int shopping_cart_id,int product_id,String product_buy_username,String product_buy_time,String product_buy_count){
        this.shopping_cart_id = shopping_cart_id;
        this.product_id = product_id;
        this.product_buy_username = product_buy_username;
        this.product_buy_time = product_buy_time;
        this.product_buy_count = product_buy_count;
    }

    public void setProduct_buy_username(String product_buy_username) {
        this.product_buy_username = product_buy_username;
    }

    public void setProduct_buy_time(String product_buy_time) {
        this.product_buy_time = product_buy_time;
    }

    public void setProduct_buy_count(String product_buy_count) {
        this.product_buy_count = product_buy_count;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setShopping_cart_id(int shopping_cart_id) {
        this.shopping_cart_id = shopping_cart_id;
    }

    public String getProduct_buy_username() {
        return product_buy_username;
    }

    public String getProduct_buy_time() {
        return product_buy_time;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getShopping_cart_id() {
        return shopping_cart_id;
    }

    public String getProduct_buy_count() {
        return product_buy_count;
    }
}
