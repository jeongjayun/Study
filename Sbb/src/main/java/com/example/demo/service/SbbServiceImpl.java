package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.mapper.SbbMapper;

@Service
public class SbbServiceImpl implements SbbService {

	@Autowired
	// SbbMapper에 있는 sql문을 impl 파일로 읽어와서의존성 주입 후 객체생성 한 것
	private SbbMapper sbbMapper;

	// 순서
	// 1. controller -> 2. service -> 3. serviceImpl -> mapper -> mapper.xml 

	@Override
	public void newQuestion(QuestionDTO questionDTO) throws Exception {
		sbbMapper.newQuestion(questionDTO);
	}

}
