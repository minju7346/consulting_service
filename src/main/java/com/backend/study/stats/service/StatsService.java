package com.backend.study.stats.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.study.stats.model.InquireDTO;
import com.backend.study.stats.mapper.StatsMapper;
import com.backend.study.stats.model.StatsDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatsService {

	private final StatsMapper statsMapper;


	public List<StatsDTO> statsCounselsByDate(LocalDate startDate, LocalDate endDate, long categoryId) {
		List<StatsDTO> statsList = new ArrayList<>();

		while(!startDate.equals(endDate)){
			statsList.add(statsMapper.selectStatsInfoByDate(startDate, categoryId));
			startDate = startDate.plusDays(1);
		}
		return statsList;
	}

	public List<List<StatsDTO>> statsCounselsByCharger(LocalDate startDate, LocalDate endDate, long categoryId) {
		List<List<StatsDTO>> statsList = new ArrayList<>();

		while(!startDate.equals(endDate)){
			statsList.add(statsMapper.selectStatsInfoByCharger(startDate, categoryId));
			startDate = startDate.plusDays(1);
		}
		return statsList;
	}

}
