package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.SbbService;

import jakarta.annotation.Resource;

@Controller
public class SbbController {

	@Resource // sql 쿼리 가져오는 어노테이션
	private SbbService sbbService; // service 를 호출하면 impl도 함께 연결됨

	@GetMapping("/")
	public ModelAndView index() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}

}
