package com.practice.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.board.dto.BoardDTO;
import com.practice.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;

	@GetMapping("/save")
	public String save() {
		return "save";
	}

	@PostMapping("/save") // 글 저장하기
	public String save(BoardDTO boardDTO) {
		System.out.println("boardDTO = " + boardDTO);
		boardService.save(boardDTO);
		return "index";
	}
	
	@PostMapping("/save2") // 글 저장하기
	public String save(BoardDTO boardDTO) {
		System.out.println("boardDTO = " + boardDTO);
		boardService.save(boardDTO);
		return "index";
	}

	@GetMapping("/list") // 글 목록 페이지로 이동
	public String findAll(Model model) {
		List<BoardDTO> boardDTOList = boardService.findAll();
		model.addAttribute("boardList", boardDTOList);
		System.out.println("boardDTOList : " + boardDTOList);
		//TODO : 타임리프로 list.html 에서 내용이 불러오기가 안됨;
		return "list";
	}
	
	

}
