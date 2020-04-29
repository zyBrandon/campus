package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface updateProductStatusByProductIdMapper {

    @Update("UPDATE product_tbl SET product_status='2' WHERE  product_id=#{product_id}")
    int updateProductStatusByProductId(@Param("product_id") int product_id);

}
