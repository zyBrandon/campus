package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface addCartMapper {
    @Insert("insert into shopping_cart_tbl(product_id,product_buy_username,product_buy_time,product_buy_count) values(#{product_id},#{product_buy_username},#{product_buy_time},1)")
    int addCart(@Param("product_id") int product_id, @Param("product_buy_username") String product_buy_username, @Param("product_buy_time") Date product_buy_time);
}
