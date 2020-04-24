package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface addAddressMapper {
    @Insert("insert into address_tbl(address,user_name,name,longtitude,latitude) values(#{address},#{user_name},#{name},#{longtitude},#{latitude})")
    int addAddress(@Param("address") String address,@Param("user_name") String user_name,@Param("name") String name,@Param("longtitude") String longtitude,@Param("latitude") String latitude);
}
