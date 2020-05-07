package com.example.demo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface deleteCartMapper {
    @Delete("delete  from shopping_cart_tbl where product_id=#{product_id} and product_buy_username=#{product_buy_username}")
    int deleteCart(@Param("product_id") int product_id,@Param("product_buy_username") String product_buy_username);
}
