package com.example.demo.mapper;

import com.example.demo.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface getAllOrderByStatusMapper {
    @Select("select * from order_tbl where product_buy_username=#{product_buy_username}")
    ArrayList<Order> getAllOrderByStatus(@Param("product_buy_username") String product_buy_username);
}
