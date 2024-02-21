package com.ecosystem.demo.sawon;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SawonController {

	private final SawonService sawonService;

	private static Logger logger = LoggerFactory.getLogger("SawonController.class");

	@GetMapping("/")
	public String index() {
		return "redirect:/list";
	}

	@GetMapping("/list")
	public String getSawonList(Model model) {
		logger.info("getSawonList 실행");
		List<SawonDTO> sawonList = sawonService.getSawonList();
		model.addAttribute("sawonList", sawonList);
		return "sawonList";
	}

	@GetMapping("/register")
	public String getRegister(Model model) {
		logger.info("사원 등록 페이지로 이동");
		model.addAttribute("sawon", new SawonDTO());
		return "register_form";
	}

	@PostMapping("/register")
	public String postRegister(SawonDTO sawonDTO) {
		logger.info("postRegister 실행");
		sawonService.register(sawonDTO);
		return "redirect:/list";
	}
}
