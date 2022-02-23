package com.backend.study.counsel.controller;

import javax.servlet.http.Cookie;

import com.backend.study.counsel.service.CounselService;
import com.backend.study.counsel.model.CounselDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.Getter;

@RestController
public class CounselController {

    @Autowired
    private CounselService counselService;

    @PostMapping("/counsel")
    public void  register(@RequestBody CounselDTO counselDTO){

        counselService.register(counselDTO);
    }

    @PatchMapping("/counsel")
    public void distribute(@CookieValue(value = "id") Cookie cookie,
            @RequestBody CounselDTO counselDTO, @RequestParam long category_id){
        String id = cookie.getValue();
        counselService.distribute(id, category_id, counselDTO);
    }

    @GetMapping("/counsel")
    public Integer getNoChargerCounsels(@CookieValue(value = "id") Cookie cookie,
            @RequestParam long category_id){
        String id = cookie.getValue();
        return counselService.getNoChargerCounsels(id, category_id);
    }

}

