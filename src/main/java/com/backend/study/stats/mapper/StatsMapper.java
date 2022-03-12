package com.backend.study.stats.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.backend.study.stats.model.StatsDTO;

@Mapper
public interface StatsMapper {
	StatsDTO selectStatsInfoByDate(
		@Param("startDate") LocalDate startDate, @Param("categoryId") long categoryId);
	List<StatsDTO> selectStatsInfoByCharger(
		@Param("startDate") LocalDate startDate, @Param("categoryId") long categoryId);
}
