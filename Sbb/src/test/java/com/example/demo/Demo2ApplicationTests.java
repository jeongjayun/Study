package com.example.demo;

import static org.mockito.ArgumentMatchers.intThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import org.hibernate.internal.build.AllowPrintStacktrace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.question.QuestionService;

@SpringBootTest
class Demo2ApplicationTests {

	@Autowired
	private QuestionService questionService;

	@Test
	@DisplayName("다량의 테스트 데이터 입력하기")
	void testJpa() {
		for (int i = 1; i <= 300; i++) {
			String subject = String.format("테스트 데이터 입니다. : [%03d]", i);
			String content = "내용 없음";
			this.questionService.create(subject, content);
		}
	}

}
