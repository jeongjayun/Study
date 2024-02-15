package com.example.demo.question;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 롬복에서 제공하는 애너테이션, final이 붙은 속성을 포함하는 생성자 자동으로 생성
@Controller
@RequestMapping("/question") // url prefix
public class QuestionController {

//	private final QuestionRepository questionRepository;
	private final QuestionService questionService;
	private final Logger logger = LoggerFactory.getLogger(QuestionController.class);

	@GetMapping("/list")
	public String list(Model model) {
		List<Question> questionList = this.questionService.getList();
//		logger.info("questionList 나오나용?");
//		System.out.println("questionList 확인 : " + questionList);
		model.addAttribute("questionList", questionList);
		return "question_list";
	}

	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		// 변하는 id값을 얻을 때에는 @PathVariable 애너테이션을 사용

		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail";
	}
	

}
