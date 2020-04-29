package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface addVisitMapper {

    @Insert("insert into product_visit_tbl(product_id,visit_user,visit_time) values(#{product_id},#{visit_user},#{visit_time})")
    int addVisit(@Param("product_id") int product_id, @Param("visit_user") String visit_user, @Param("visit_time") Date visit_time);

}
