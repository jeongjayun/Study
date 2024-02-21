package com.ecosystem.demo;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecosystem.demo.sawon.SawonDTO;
import com.ecosystem.demo.sawon.SawonRepository;

@SpringBootTest
class SawonApplicationTests {
	
	@Autowired
	SawonRepository sawonRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	@DisplayName("테이블 값 가져오기")
	public void getSawonList() {
		List<SawonDTO> testList = sawonRepository.getSawonList();
		System.out.println("testList : " + testList);
	}

}
