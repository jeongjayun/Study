package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.question.Question;

@Mapper
public interface SbbMapper {
	
	Question selectById(Integer id);

}
