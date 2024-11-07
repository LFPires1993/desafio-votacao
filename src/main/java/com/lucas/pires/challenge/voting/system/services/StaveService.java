package com.lucas.pires.challenge.voting.system.services;

import com.lucas.pires.challenge.voting.system.dtos.StaveDto;
import com.lucas.pires.challenge.voting.system.dtos.adapters.CreateStaveAdapter;
import com.lucas.pires.challenge.voting.system.repositories.StaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StaveService {

    @Autowired
    private StaveRepository _staveRepository;

    public ResponseEntity<?> createStave(CreateStaveAdapter staveRequest) {
        try {
            if (staveRequest.title.isBlank() || staveRequest.description.isBlank()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Title and description are mandatory!");
            }

            if (staveRequest.minutesDuration < 1) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Minutes duration can't be less then 1 minute!");
            }

            var stave = new StaveDto(staveRequest);

            var staveResponse = _staveRepository.create(stave);

            return ResponseEntity.status(HttpStatus.CREATED).body(staveResponse);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Internal error!");
        }
    }
}
