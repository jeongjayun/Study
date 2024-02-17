package com.example.demo.answer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.question.Question;
import com.example.demo.question.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {

	private final QuestionService questionService;
	private final AnswerService answerService;

	@PostMapping("/create/{id}")
	public String createAnswer(Model model, @PathVariable("id") Integer id,
			@Valid AnswerForm answerForm, BindingResult bindingResult) {
		Question question = this.questionService.getQuestion(id);
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("question", question);
			return "question_detail";
		}
		
		this.answerService.create(question, answerForm.getContent());
		
		// TODO: (해야 할 일)와 같이 주석을 작성하여 개발자들이 주로 코드 내에서
		// 아직 해결되지 않은 문제나 추가로 작업해야 하는 부분을 표시한다.
		// 말 그대로 ‘To do’, 즉 할 일을 의미한다.
		
		return String.format("redirect:/question/detail/%s", id);
	}

}
