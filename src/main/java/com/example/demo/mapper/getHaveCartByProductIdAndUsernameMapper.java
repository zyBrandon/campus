package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface getHaveCartByProductIdAndUsernameMapper {
    @Select("select count(*) from shopping_cart_tbl where product_buy_username=#{product_buy_username} and product_id=#{product_id}")
    int getHaveCartByProductIdAndUsername(@Param("product_buy_username") String product_buy_username,@Param("product_id") int product_id);
}
