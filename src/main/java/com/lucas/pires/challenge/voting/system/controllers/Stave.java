package com.lucas.pires.challenge.voting.system.controllers;

import com.lucas.pires.challenge.voting.system.dtos.adapters.CreateStaveAdapter;
import com.lucas.pires.challenge.voting.system.services.StaveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stave/")
public class Stave {
    @Autowired
    private StaveService _staveService;

    @Operation(summary = "Create stave")
    @ApiResponse(responseCode = "200", description = "Create a new stave", content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal error!", content = @Content(mediaType = "application/json"))
    @PostMapping
    public ResponseEntity<?> createStave(@RequestBody CreateStaveAdapter staveRequest) {
        return _staveService.createStave(staveRequest);
    }
}
