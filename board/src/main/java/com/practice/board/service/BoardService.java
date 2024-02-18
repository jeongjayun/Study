package com.practice.board.service;

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

}
