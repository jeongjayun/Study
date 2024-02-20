package com.practice.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.practice.board.dto.BoardDTO;
import com.practice.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository;

	public void save(BoardDTO boardDTO) {
		boardRepository.save(boardDTO);
	}

	public void save2(Map<String, Object> map) {
		// map 에서 데이터 추출
		String boardTitle = (String) map.get("boardTitle");
		String boardWriter = (String) map.get("boardWriter");
		String boardPass = (String) map.get("boardPass");
		String boardContents = (String) map.get("boardContents");

		// 데이터 저장
		Map<String, Object> board = new HashMap();
		board.put("boardTitle", boardTitle);
		board.put("boardWriter", boardWriter);
		board.put("boardPass", boardPass);
		board.put("boardContents", boardContents);
		
		System.out.println("save2 에서 service 확인 : " + board);
		boardRepository.save2(board);
	}

	public List<BoardDTO> getList() {
		return boardRepository.getList();
	}

	public void updateHits(Long id) {
		boardRepository.updateHits(id);
	}

	public BoardDTO findById(Long id) {
		return boardRepository.findById(id);
	}

	public void update(BoardDTO boardDTO) {
		boardRepository.update(boardDTO);
	}

	public void delete(Long id) {
		boardRepository.delete(id);
	}

}
