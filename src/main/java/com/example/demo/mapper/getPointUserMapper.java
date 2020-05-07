package com.example.demo.mapper;

import com.example.demo.model.Point;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface getPointUserMapper {
    @Select("select * from point_tbl")
    ArrayList<Point> getPointUser();
}
