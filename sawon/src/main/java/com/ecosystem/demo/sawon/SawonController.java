package com.ecosystem.demo.sawon;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SawonController {

	private final SawonService sawonService;

	private static Logger logger = LoggerFactory.getLogger("SawonController.class");

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	//thymleaf
	@GetMapping("/thymeleafList")
	public String getThymeleafList(Model model) {
		List<SawonDTO> sawonList = sawonService.getSawonList();
		model.addAttribute("sawonList", sawonList);
		return "thymeleafList";
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
		return "redirect:/";
	}

	// jqgrid
	@GetMapping("/jqGrid")
	public String getJqGridList(Model model) {
		List<SawonDTO> sawonList = sawonService.getSawonList();
		model.addAttribute("sawonList", sawonList);
		return "jqGrid";
	}
	
	@RequestMapping(value = "/jsonGetSawonList", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public List<SawonDTO> jqList(SawonDTO sawonDto, Model model) throws Exception {
		List<SawonDTO> sawonList = sawonService.getSawonList();
		logger.info("jqGrid에서 url : /jsonGetSawonList 실행 : " + sawonList);
		model.addAttribute("list", sawonList);
		return sawonList;
	}

}
