package com.practice.board.json;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LombokTest {
	@Test
	public void ResultTest() {
		ResultVO result=new ResultVO(0, "hong");
		System.out.println(result);
	}

}
