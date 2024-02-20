package com.practice.board.repository;

import java.util.List;
import java.util.Map;

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
	
	public Map<String, Object> save2(Map<String, Object> board) {
		sql.insert("Board.save2", board);
		return board;
	}

	public List<BoardDTO> getList() {
		return sql.selectList("Board.getList");
	}

	public void updateHits(Long id) {
		sql.update("Board.updateHits", id);
	}

	public BoardDTO findById(Long id) {
		return sql.selectOne("Board.findById", id);
	}
	
	public void update(BoardDTO boardDTO) {
		sql.update("Board.update", boardDTO);
	}
	
	public void delete(Long id) {
		sql.delete("Board.delete", id);
	}
}