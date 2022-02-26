package com.backend.study.counsel.controller;

import javax.servlet.http.Cookie;

import com.backend.study.counsel.service.CounselService;
import com.backend.study.counsel.model.CounselDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class CounselController {

    @Autowired
    private CounselService counselService;

    @PostMapping("/counsel")
    public void  register(@RequestBody CounselDTO counselDTO, @RequestParam long counselId){
        counselService.register(counselDTO, counselId);
    }

    @PatchMapping("/counsel/{categoryId}")
    public void distribute(@CookieValue(value = "id") Cookie cookie,
            @RequestParam long counselId, @PathVariable long categoryId){
        String id = cookie.getValue();
        counselService.distribute(id, categoryId, counselId);
    }

    @GetMapping("/counsel/{categoryId}")
    public Integer countNoChargerCounsels(@CookieValue(value = "id") Cookie cookie,
            @PathVariable long categoryId){
        String id = cookie.getValue();
        return counselService.getNoChargerCounsels(id, categoryId);
    }

}

