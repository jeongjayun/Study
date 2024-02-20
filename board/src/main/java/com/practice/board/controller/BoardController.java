package com.practice.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
		return "redirect:/list";
	}
	
	@ResponseBody
	@PostMapping("/jsonAjaxTest") // ajax를 map으로 받아오는 경우
	public int jsonAjaxTest(@RequestBody Map<String, Object> map) {

		System.out.println("map : " + map);

		Map<String, Object> temp = new HashMap<>();

		temp.put("boardTitle", map.get("boardTitle"));
		temp.put("boardWriter", map.get("boardWriter"));
		temp.put("boardPass", map.get("boardPass"));
		temp.put("boardContents", map.get("boardContents"));

		System.out.println("tempt : " + temp);
		
		boardService.save2(temp);
		
		return 1;
	}

	/*
	 * @ResponseBody
	 * 
	 * @PostMapping("/jsonAjaxTest") // ajax를 list<map -- 형식으로 받아오는 경우 public void
	 * jsonAjaxTest(@RequestBody List<Map<String, Object>> param) { List<Map<String,
	 * Object>> tempList = new ArrayList<>(); Map<String, Object> map1 = new
	 * HashMap<>(); map1.put("boardTitle", param.get(0).get("boardTitle"));
	 * tempList.add(0, map1); System.out.println("tempList : " + tempList); }
	 */

	@GetMapping("/list") // 글 목록 페이지로 이동
	public String getList(Model model) {
		List<BoardDTO> boardDTOList = boardService.getList();
		model.addAttribute("boardList", boardDTOList);
		return "list";
	}

	@GetMapping("/{id}") // 게시글 조회
	public String getPost(@PathVariable("id") Long id, Model model) {
		// 조회수
		boardService.updateHits(id);
		// 상세내용
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute("board", boardDTO);
		return "detail";
	}

	@GetMapping("/update/{id}")
	public String getUpdate(@PathVariable("id") Long id, Model model) {
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute(boardDTO);
		return "update";
	}

	@PostMapping("/update/{id}")
	public String postUpdate(BoardDTO boardDTO, Model model) {
		boardService.update(boardDTO);
		BoardDTO dto = boardService.findById(boardDTO.getId());
		model.addAttribute("board", dto);
		// TODO : 수정페이지로 이동할 때 fail
		return "detail";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		boardService.delete(id);
		return "redirect:/list";
	}

}
