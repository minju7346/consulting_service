package com.backend.study.counsel.mapper;

import com.backend.study.counsel.dto.CounselDTO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CounselMapper {
    void insertCounsel(CounselDTO counselDTO);
    void insertCounselHistory(CounselDTO counselDTO);
}