package com.ecosystem.demo.sawon;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SawonService {

	private final SawonRepository sawonRepository;

	public List<SawonDTO> getSawonList() {
		return sawonRepository.getSawonList();
	}

	public void register(SawonDTO sawonDTO) {
		sawonRepository.register(sawonDTO);
	}

}
