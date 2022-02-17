package com.backend.study.counsel.controller;

import com.backend.study.counsel.service.CounselService;
import com.backend.study.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CounselController {
    @Value("${db.driverClassName}")
    private String driver;

    @Autowired
    private CounselService counselService;

    @PostMapping("/api/registerCounsel")
    public void  registerCounsel(@RequestParam("category_id") long category_id, @RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("customer_name") String customer_name,@RequestParam("customer_email") String customer_email, @RequestParam("creator_id") String creator_id, @RequestParam("modifier_id") String modifier_id){
        counselService.registerCounsel(category_id, title, content, customer_name, customer_email, creator_id, modifier_id);
    }
}

