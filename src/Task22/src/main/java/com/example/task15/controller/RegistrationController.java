package com.example.task15.controller;

import com.example.task15.entities.UserEntity;
import com.example.task15.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity registerUser(@RequestBody UserEntity user) {
        boolean isSuccess = userService.saveUser(user);
        if (isSuccess) {
            return ResponseEntity.ok("User was added");
        }
        return ResponseEntity.badRequest().body("Something went wrong");
    }
}
