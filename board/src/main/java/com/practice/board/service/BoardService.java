package com.practice.board.service;

import java.util.List;

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
	
	public List<BoardDTO> findAll(){
		return boardRepository.findAll();
	}

}
