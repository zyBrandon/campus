package com.example.demo.mapper;

import com.example.demo.model.Product_Visit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface getVisitMostMapper {
    @Select("select * from product_visit_tbl order by visit_count limit #{hotcount}")
    ArrayList<Product_Visit> getVisitMost(@Param("hotcount") int hotcount);
}
