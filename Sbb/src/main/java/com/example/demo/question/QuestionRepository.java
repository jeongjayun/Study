package com.example.demo.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	Question findBySubject(String subject);
	Question findBySubjectAndContent(String subject, String content);
	
	List<Question> findBySubjectLike(String subject);
	//특정 문자열을 포함하는 데이터 조회 
	//sql에서는 특정 문자열을 포함한 데이터를 열에서 찾을 때 like를 사용한다.
	
	Page<Question> findAll(Pageable pageable);
	//Pageable 객체를 입력받아 page<Question> 타입 객체를 반환하는 findAll 메서드 생성

}
