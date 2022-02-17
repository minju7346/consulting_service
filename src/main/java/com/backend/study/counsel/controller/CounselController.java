package com.backend.study.counsel.controller;

import com.backend.study.counsel.service.CounselService;
import com.backend.study.counsel.dto.CounselDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CounselController {

    @Autowired
    private CounselService counselService;

    @PostMapping("/counsel/register")
    public void  registerCounsel(@RequestBody CounselDTO counselDTO){
        counselService.registerCounsel(counselDTO);
    }
}

