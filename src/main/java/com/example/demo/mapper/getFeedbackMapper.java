package com.example.demo.mapper;

import com.example.demo.model.Feedback;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface getFeedbackMapper {
    @Select("select * from feedback_tbl order by feedback_time desc")
    ArrayList<Feedback> getFeedback();
}
