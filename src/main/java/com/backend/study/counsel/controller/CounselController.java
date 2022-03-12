package com.backend.study.counsel.controller;

import com.backend.study.counsel.service.CounselService;
import com.backend.study.counsel.model.CounselDTO;
import com.backend.study.user.model.LoginUser;
import com.backend.study.user.model.LoginUserDTO;
import com.backend.study.user.model.Permission;
import com.backend.study.user.model.enums.UserRole;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CounselController {

    private final CounselService counselService;

    @GetMapping("/")
    public String hello(){
        return "Hello";
    }

    @PostMapping("/counsels")
    public void  register(@RequestBody CounselDTO counselDTO){

        counselService.register(counselDTO);
    }

    @PatchMapping("/counsels/{categoryId}/distribute")
    public void distribute(@LoginUser LoginUserDTO loginUserDTO,
            @RequestParam long counselId, @PathVariable long categoryId){
        counselService.distribute(loginUserDTO.getId(), categoryId, counselId);
    }

    @GetMapping("/counsels/{categoryId}/no-chargers-count")
    public Integer countNoChargerCounsels(@LoginUser LoginUserDTO loginUserDTO,
            @PathVariable long categoryId){
        return counselService.countNoChargerCounsels(loginUserDTO.getId(), categoryId);
    }

}

