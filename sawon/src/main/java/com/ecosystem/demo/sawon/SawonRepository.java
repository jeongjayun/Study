package com.ecosystem.demo.sawon;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SawonRepository {
	private final SqlSessionTemplate sql; 
	
	public List<SawonDTO> getSawonList(){
		return sql.selectList("Sawon.getSawonList");	
	}
	
	public void register(SawonDTO sawonDTO) {
		sql.insert("Sawon.register", sawonDTO);
	}

}
