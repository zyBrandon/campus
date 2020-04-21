package com.example.demo.model;

public class Address {
    public int address_id;
    public String address;
    public String user_name;
    public String latitude;
    public String longtitude;

    public Address(int address_id,String address,String user_name,String latitude,String longtitude){
        this.address = address;
        this.address_id = address_id;
        this.user_name = user_name;
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    public int getAddress_id() {
        return address_id;
    }

    public String getAddress() {
        return address;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
