package com.example.demo.mapper;

//import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Advertising;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface getAdvertisingMapper {

    @Select("select * from advertising_tbl limit 3")
    ArrayList<Advertising>  getAdvertising();
}
