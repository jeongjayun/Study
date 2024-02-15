package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class DataNotFoundException extends RuntimeException {
	// RuntimeException : 실행 시 발생하는 예외.
	// RuntimeException 클래스를 상속하는 것 = 사용자 정의 예외 클래스를 정의하는 방법 중 하나
	
	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String message) {
		super(message);
	}
}
