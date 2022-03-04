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

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CounselController {

    private final CounselService counselService;

    @PostMapping("/counsel")
    public void  register(@RequestBody CounselDTO counselDTO){
        counselService.register(counselDTO);
    }

    @Permission(authority = UserRole.MANAGER)
    @PatchMapping("/counsel/{categoryId}")
    public void distribute(@CookieValue(name="id") String id,
            @RequestParam long counselId, @PathVariable long categoryId){
        counselService.distribute(id, categoryId, counselId);
    }

    @Permission(authority = UserRole.MANAGER)
    @GetMapping("/counsel/{categoryId}")
    public Integer countNoChargerCounsels(@CookieValue(name="id") String id,
            @PathVariable long categoryId){
        return counselService.countNoChargerCounsels(id, categoryId);
    }

    @Permission(authority = UserRole.COUNSELOR)
    @PostMapping("/answer")
    public void answerCounsel(@CookieValue(name="id") String chargerId,
        @Valid @RequestBody AnswerDTO answerDTO){

        counselService.answerCounsel(chargerId, answerDTO);
    }


}

