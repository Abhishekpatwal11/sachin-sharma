package com.example.signUp.Service;

import com.example.signUp.Common.UserResponse;
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
//public class SignUpService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    public ResponseEntity<?> signedUp(UserDTO userDTO) {
//
////        Optional<User> checkUser = userRepository.findByEmail(userDTO.getEmail());
////        if (checkUser.isPresent()) {
////            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exist");
////        }
////
////        User saveUser = modelMapper.map(userDTO, User.class);
////        User savedUser = userRepository.save(saveUser);
////
////        return ResponseEntity.status(HttpStatus.CREATED)
////                .body(savedUser);
//
//
//        try {
//            User user = new User();
//            Optional<User> existing = userRepository.findByEmail(user.getEmail());
//
//            if (existing.isPresent()) {
//                System.out.println("user already exists");
//
//            } else if (!user.getEmail().matches("[a-zA-Z0-9._%l-]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$")) {
//                System.out.println("Invalid Email");
//            } else {
//                user.setfName(userDTO.getfName().trim());
//                user.setlName(userDTO.getlName().trim());
//                user.setEmail(userDTO.getEmail().trim());
//                userRepository.save(user);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO("Successfully registered", "success"));
//    }
//}
public class SignUpService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<?> signedUp(UserDTO userDTO) {
        try {
            // Check if the user already exists by email
            Optional<User> existingUser = userRepository.findByEmail(userDTO.getEmail().trim());
            if (existingUser.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new MessageDTO("User already exists", "error"));
            }

            // Validate email format
            String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            if (!userDTO.getEmail().matches(emailRegex)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new MessageDTO("Invalid email format", "error"));
            }

            // Map UserDTO to User entity
            User user = modelMapper.map(userDTO, User.class);

            // Trim and set user fields
            user.setfName(userDTO.getfName().trim());
            user.setlName(userDTO.getlName().trim());
            user.setEmail(userDTO.getEmail().trim());
            user.setPassword(userDTO.getPassword().trim());

            // Save user to the database
            userRepository.save(user);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new MessageDTO("Successfully registered", "success"));

        } catch (Exception e) {
            // Handle unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MessageDTO("An error occurred: " + e.getMessage(), "error"));
        }
    }
    public UserResponse login(UserDTO userDTO)
    {
        Optional<User> user = userRepository.findByEmail(userDTO.getEmail());
        if(user.isPresent())
        {
            String password=userDTO.getPassword();
            String securePassword = user.get().getPassword();
            if(password.equals(securePassword))
            {
                return new UserResponse("Login Successfully. Token: " , true);
            }
            else {
                return new UserResponse("Login Failed",false);
            }
        }
        return new UserResponse("Email do not exists", false);
    }
}
