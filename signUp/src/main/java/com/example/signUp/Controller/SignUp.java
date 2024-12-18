package com.example.signUp.Controller;

import com.example.signUp.DTO.UserDTO;
import com.example.signUp.Service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SignUp {

    @Autowired
    public Iservice service;

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody UserDTO userDTO)
    {
        return service.signedUp(userDTO);
    }

    @GetMapping("/")
    public String notFound()
    {
        return "Page  not found";
    }
}
