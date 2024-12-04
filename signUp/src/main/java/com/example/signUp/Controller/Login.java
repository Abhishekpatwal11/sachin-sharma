package com.example.signUp.Controller;

import com.example.signUp.Common.UserResponse;
import com.example.signUp.DTO.UserDTO;
import com.example.signUp.Service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class Login {

    @Autowired
    Iservice service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO)
    {
       UserResponse userResponse = service.login(userDTO);
       return ResponseEntity.ok(userResponse);
    }
}
