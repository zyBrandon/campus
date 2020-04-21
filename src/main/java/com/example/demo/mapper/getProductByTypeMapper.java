package com.example.demo.mapper;

import com.example.demo.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface getProductByTypeMapper {
    @Select("select * from product_tbl where product_type=#{type} and product_status='1'")
    ArrayList<Product> getProductByType(@Param("type") String type);
}
