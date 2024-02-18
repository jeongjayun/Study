package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.question.Question;

@Mapper
public interface SbbMapper {
	
	public void newQuestion(QuestionDTO questionDTO) throws Exception; //질문 등록하기 

}
