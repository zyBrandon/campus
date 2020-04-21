package com.example.demo.mapper;

import com.example.demo.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface getProductByProductIdMapper {
    @Select("select * from product_tbl where product_id=#{product_id}")
    Product getProductByProductId(@Param("product_id") int product_id);
}
