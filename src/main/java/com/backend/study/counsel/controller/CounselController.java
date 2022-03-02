package com.backend.study.counsel.controller;

import javax.servlet.http.Cookie;
import javax.validation.Valid;

import com.backend.study.counsel.model.AnswerDTO;
import com.backend.study.counsel.service.CounselService;
import com.backend.study.counsel.model.CounselDTO;
import com.backend.study.user.model.Permission;
import com.backend.study.user.model.enums.UserRole;

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

    @Permission(authority = UserRole.MANAGER)
    @PatchMapping("/counsel/{categoryId}")
    public void distribute(@CookieValue(value = "id") Cookie cookie,
            @RequestParam long counselId, @PathVariable long categoryId){
        String id = cookie.getValue();
        counselService.distribute(id, categoryId, counselId);
    }

    @Permission(authority = UserRole.MANAGER)
    @GetMapping("/counsel/{categoryId}")
    public Integer countNoChargerCounsels(@CookieValue(value = "id") Cookie cookie,
            @PathVariable long categoryId){
        String id = cookie.getValue();
        return counselService.countNoChargerCounsels(id, categoryId);
    }

    @Permission(authority = UserRole.COUNSELOR)
    @PostMapping("/answer")
    public void answerCounsel(@CookieValue(value = "id") Cookie cookie,
        @Valid @RequestBody AnswerDTO answerDTO){

        String chargerId = cookie.getValue();
        counselService.answerCounsel(chargerId, answerDTO);
    }


}

