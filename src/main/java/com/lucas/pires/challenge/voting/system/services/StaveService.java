package com.lucas.pires.challenge.voting.system.services;

import com.lucas.pires.challenge.voting.system.dtos.StaveDto;
import com.lucas.pires.challenge.voting.system.dtos.adapters.CreateStaveAdapter;
import com.lucas.pires.challenge.voting.system.dtos.adapters.ResponseAllStaveAdapter;
import com.lucas.pires.challenge.voting.system.dtos.adapters.ResponseFinalizeStave;
import com.lucas.pires.challenge.voting.system.repositories.StaveRepository;
import com.lucas.pires.challenge.voting.system.utils.ErrorMessageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StaveService {

    @Autowired
    private StaveRepository _staveRepository;

    public ResponseEntity<?> getAllStaves() {
        try {
            var staveResponse = _staveRepository.getAll();

            var staveResponseAdapter = staveResponse
                    .stream()
                    .map(ResponseAllStaveAdapter::new)
                    .toList();

            return ResponseEntity.status(HttpStatus.OK).body(staveResponseAdapter);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new ErrorMessageObject("Internal error!"));
        }
    }

    public ResponseEntity<?> getStaveById(int id) {
        try {
            var staveResponse = _staveRepository.getById(id);

            if (staveResponse == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessageObject("Stave not found!"));
            }

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseFinalizeStave(staveResponse));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new ErrorMessageObject("Internal error!"));
        }
    }

    public ResponseEntity<?> createStave(CreateStaveAdapter staveRequest) {
        try {
            if (staveRequest.title.isBlank() || staveRequest.description.isBlank()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessageObject("Title and description are mandatory!"));
            }

            if (staveRequest.minutesDuration < 1) {
                staveRequest.minutesDuration = 1;
            }

            var stave = new StaveDto(staveRequest);

            var staveResponse = _staveRepository.create(stave);

            return ResponseEntity.status(HttpStatus.CREATED).body(staveResponse);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new ErrorMessageObject("Internal error!"));
        }
    }
}
