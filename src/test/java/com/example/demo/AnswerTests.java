package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.answer.Answer;
import com.example.demo.question.Question;
import com.example.demo.question.QuestionRepository;

@SpringBootTest
public class AnswerTests {
	
	@Autowired
	private QuestionRepository questionRepository;

//	@Test
//	@DisplayName("답변 저장하기")
//	void TestJpa9() {
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//
//		Answer a = new Answer();
//		a.setContent("네, 자동으로 생성됩니다.");
//		a.setCreateDate(LocalDateTime.now());
//		a.setQuestion(q);
//		this.answerRepository.save(a);
//	}

//	@Test
//	@DisplayName("답변 조회하기")
//	void TestJpa10() {
//		Optional<Answer> oa = this.answerRepository.findById(1);
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		assertEquals(2, a.getQuestion().getId());
//	}

	@Test
	@DisplayName("답변 통해 질문 찾기")
	@Transactional
	void TestJpa11() {
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		// 테스트코드에서만 QuestionRepository가 findById 메서드를 통해 Question 객체를 조회하고 나면 DB 세션이 끊어지기 때문
		// Transactional 어노테이션 적용해주면 테스트 코드에서 실행 가능
		
		List<Answer> answerList=q.getAnswerList();
		
		assertEquals(1, answerList.size());
        assertEquals("네, 자동으로 생성됩니다.", answerList.get(0).getContent());
	}

}
