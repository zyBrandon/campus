package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface addFeedbackMapper {
    @Insert("insert into feedback_tbl(feedback_user,feedback_title,feedback_content,feedback_time) values(#{feedback_user},#{feedback_title},#{feedback_content},#{feedback_time})")
    int addFeedback(@Param("feedback_user") String feedback_user,@Param("feedback_title") String feedback_title,@Param("feedback_content") String feedback_content,@Param("feedback_time") Date feedback_time);
}
