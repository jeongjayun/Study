package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.question.Question;

public class AnswerDTO {
	    private Integer id;
	    private String content;
	    private LocalDateTime createDate; 
	    private Question question; 
}
