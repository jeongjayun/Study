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
