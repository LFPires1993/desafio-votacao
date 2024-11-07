package com.lucas.pires.challenge.voting.system.controllers;

import com.lucas.pires.challenge.voting.system.dtos.adapters.CreateUserAdapter;
import com.lucas.pires.challenge.voting.system.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class User {

    @Autowired
    private UserService _userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserAdapter userRequest) {
        return _userService.createUser(userRequest);
    }
}
