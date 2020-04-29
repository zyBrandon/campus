package com.example.demo.mapper;

import com.example.demo.model.Product_Visit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface getVisitMostMapper {
    @Select("SELECT DISTINCT product_id FROM product_visit_tbl WHERE product_id IN(SELECT product_id AS NUM  FROM product_visit_tbl GROUP BY product_id ORDER BY NUM DESC) limit #{hotcount}")
    ArrayList<Integer> getVisitMost(@Param("hotcount") int hotcount);
}
