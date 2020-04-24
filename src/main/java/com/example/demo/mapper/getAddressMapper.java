package com.example.demo.mapper;

import com.example.demo.model.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface getAddressMapper {
    @Select("select * from address_tbl where user_name=#{user_name}")
    ArrayList<Address> getAddress(@Param("user_name") String user_name);
}
