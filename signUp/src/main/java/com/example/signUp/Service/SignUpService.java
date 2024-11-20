package com.example.signUp.Service;

import com.example.signUp.DTO.MessageDTO;
import com.example.signUp.DTO.UserDTO;
import com.example.signUp.Model.User;
import com.example.signUp.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignUpService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<?> signedUp(UserDTO userDTO) {

//        Optional<User> checkUser = userRepository.findByEmail(userDTO.getEmail());
//        if (checkUser.isPresent()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exist");
//        }
//
//        User saveUser = modelMapper.map(userDTO, User.class);
//        User savedUser = userRepository.save(saveUser);
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(savedUser);


        try {
            User user = new User();
            Optional<User> existing = userRepository.findByEmail(user.getEmail());

            if (existing.isPresent()) {
                System.out.println("user already exists");

            } else if (!user.getEmail().matches("[a-zA-Z0-9._%l-]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$")) {
                System.out.println("Invalid Email");
            } else {
                user.setfName(userDTO.getfName().trim());
                user.setlName(userDTO.getlName().trim());
                user.setEmail(userDTO.getEmail().trim());
                userRepository.save(user);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO("Successfully registered", "success"));
    }
}
