package com.example.signUp.Service;

import com.example.signUp.DTO.UserDTO;
import org.springframework.http.ResponseEntity;

public interface Iservice {
    ResponseEntity<?> signedUp(UserDTO userDTO);
}
