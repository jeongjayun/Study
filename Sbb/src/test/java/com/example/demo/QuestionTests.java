package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.question.Question;
import com.example.demo.question.QuestionRepository;

@SpringBootTest
public class QuestionTests {

	@Autowired
	QuestionRepository questionRepository;

	@Test
	@DisplayName("질문 추가")
	void testJpa() {
		Question q1 = new Question();
		q1.setSubject("sbb가 뭔가요?");
		q1.setContent("sbb가 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1); // q1 저장

		Question q2 = new Question();
		q2.setSubject("스프링부트 모델 질문입니다.");
		q2.setContent("id는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2); // q2 저장
	}

	@Test
	@DisplayName("질문 수 확인")
	void testJpa2() {
		List<Question> all = this.questionRepository.findAll();
		assertEquals(2, all.size());

		Question q = all.get(0);
		assertEquals("sbb가 뭔가요?", q.getSubject());
	}

	@Test
	@DisplayName("질문 아이디 검색")
	void testJpa3() {
		Optional<Question> oq = this.questionRepository.findById(1);
		if (oq.isPresent()) {
			Question q = oq.get();
			assertEquals("sbb가 뭔가요?", q.getSubject());
		}
	}

	@Test
	@DisplayName("질문 제목 검색")
	void testJpa4() {
		Question q = this.questionRepository.findBySubject("sbb가 뭔가요?");
		assertEquals(1, q.getId());
	}

	@Test
	@DisplayName("질문 제목 및 내용 검색")
	void testJpa5() {
		Question q = this.questionRepository.findBySubjectAndContent("sbb가 뭔가요?", "sbb가 알고 싶습니다.");
		assertEquals(1, q.getId());
	}

	@Test
	@DisplayName("제목과 일치하는 내용 검색")
	void testJpa6() {
		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
		Question q = qList.get(0);
		assertEquals("sbb가 뭔가요?", q.getSubject());
	}

	@Test
	@DisplayName("제목 수정하기")
	void TestJpa7() {
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		q.setSubject("수정된 제목");
		this.questionRepository.save(q);
	}

	@Test
	@DisplayName("삭제하기")
	void TestJpa8() {
		assertEquals(2, this.questionRepository.count());
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		this.questionRepository.delete(q);
		assertEquals(1, this.questionRepository.count());
	}

}
