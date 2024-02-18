package com.practice.board.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.practice.board.dto.BoardDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
	private final SqlSessionTemplate sql;

	public BoardDTO save(BoardDTO boardDTO) {
		sql.insert("Board.save", boardDTO);
		return boardDTO;
	}
}