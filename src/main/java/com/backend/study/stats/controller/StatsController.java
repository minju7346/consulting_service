package com.backend.study.stats.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.study.stats.model.InquireDTO;
import com.backend.study.stats.model.StatsDTO;
import com.backend.study.stats.service.StatsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StatsController {

	private final StatsService statsService;

	@GetMapping("/counsels/stats-date")
	public List<StatsDTO> statsCounselsByDate(
		@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
		@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
		@RequestParam("categoryId") long categoryId) {
		return statsService.statsCounselsByDate(startDate, endDate, categoryId);
	}

	@GetMapping("/counsels/stats-charger")
	public List<List<StatsDTO>> statsCounselsByCharger(
		@RequestParam("startDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
		@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
		@RequestParam("categoryId") long categoryId) {
		return statsService.statsCounselsByCharger(startDate, endDate, categoryId);
	}
}
