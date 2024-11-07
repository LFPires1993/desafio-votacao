package com.lucas.pires.challenge.voting.system.controllers;

import com.lucas.pires.challenge.voting.system.dtos.adapters.CreateStaveAdapter;
import com.lucas.pires.challenge.voting.system.dtos.adapters.VoteAdapter;
import com.lucas.pires.challenge.voting.system.services.StaveService;
import com.lucas.pires.challenge.voting.system.services.VoteService;
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
@RequestMapping("/vote/")
public class Vote {
    @Autowired
    private VoteService _voteService;

    @Operation(summary = "Vote in a stave")
    @ApiResponse(responseCode = "200", description = "Voted", content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Internal error!", content = @Content(mediaType = "application/json"))
    @PostMapping
    public ResponseEntity<?> vote(@RequestBody VoteAdapter voteRequest) {
        return _voteService.vote(voteRequest);
    }
}
