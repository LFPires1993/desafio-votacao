package com.lucas.pires.challenge.voting.system.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Welcome {

    @Operation(summary = "Welcome to application")
    @ApiResponse(responseCode = "200", description = "Welcome message", content = @Content(mediaType = "application/text"))
    @GetMapping
    public String getWelcome() {
        return "Bem vindo(a) ao sistema de votação.";
    }

    @Operation(summary = "Welcome to application with name")
    @ApiResponse(responseCode = "200", description = "Welcome message", content = @Content(mediaType = "application/text"))
    @GetMapping("{name}")
    public String getWelcomeWithName(@Parameter(description = "Operators name") @PathVariable String name) {
        return "Bem vindo(a) ao sistema de votação %s.".formatted(name);
    }
}

