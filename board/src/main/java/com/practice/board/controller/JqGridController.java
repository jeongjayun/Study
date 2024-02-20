package com.practice.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JqGridController {
	@GetMapping("/jqgrid")
	public String getJqgrid() {
		return "jqgrid";
	}

}
