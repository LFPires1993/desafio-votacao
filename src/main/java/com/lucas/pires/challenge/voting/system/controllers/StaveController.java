package com.lucas.pires.challenge.voting.system.controllers;

import com.lucas.pires.challenge.voting.system.dtos.adapters.CreateStaveAdapter;
import com.lucas.pires.challenge.voting.system.services.StaveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stave/")
@Tag(name = "Stave")
public class StaveController {
    @Autowired
    private StaveService _staveService;

    @Operation(summary = "Get all staves")
    @ApiResponse(responseCode = "200", description = "A list of staves!", content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal error!", content = @Content(mediaType = "application/json"))
    @GetMapping
    public ResponseEntity<?> getAllStaves() {
        return _staveService.getAllStaves();
    }

    @Operation(summary = "Get stave by id")
    @ApiResponse(responseCode = "200", description = "A stave with all properties!", content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal error!", content = @Content(mediaType = "application/json"))
    @GetMapping("{id}")
    public ResponseEntity<?> getStaveById(@Parameter(description = "Stave Id") @PathVariable int id) {
        return _staveService.getStaveById(id);
    }

    @Operation(summary = "Create stave")
    @ApiResponse(responseCode = "200", description = "Create a new stave", content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal error!", content = @Content(mediaType = "application/json"))
    @PostMapping
    public ResponseEntity<?> createStave(@RequestBody CreateStaveAdapter staveRequest) {
        return _staveService.createStave(staveRequest);
    }
}
