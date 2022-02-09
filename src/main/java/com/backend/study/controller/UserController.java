package com.backend.study.controller;

import com.backend.study.dto.ResponseDTO;
import com.backend.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/app/")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "findAll", method = RequestMethod.POST)
    public ResponseEntity<?> findAll(){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResultCode("S0001");
        responseDTO.setRes(userService.findAll());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
