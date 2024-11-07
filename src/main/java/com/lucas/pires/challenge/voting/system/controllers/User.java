package com.lucas.pires.challenge.voting.system.controllers;

import com.lucas.pires.challenge.voting.system.dtos.adapters.CreateUserAdapter;
import com.lucas.pires.challenge.voting.system.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/")
public class User {

    @Autowired
    private UserService _userService;

    @Operation(summary = "Create employee")
    @ApiResponse(responseCode = "200", description = "Get all users", content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal error!", content = @Content(mediaType = "application/json"))
    @GetMapping
    public ResponseEntity<?> getAll() {
        return _userService.getAll();
    }

    @Operation(summary = "Create employee")
    @ApiResponse(responseCode = "200", description = "Create a new system user", content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal error!", content = @Content(mediaType = "application/json"))
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserAdapter userRequest) {
        return _userService.createUser(userRequest);
    }
}
