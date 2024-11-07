package com.lucas.pires.challenge.voting.system.services;

import com.lucas.pires.challenge.voting.system.dtos.adapters.VoteAdapter;
import com.lucas.pires.challenge.voting.system.repositories.StaveRepository;
import com.lucas.pires.challenge.voting.system.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VoteService {

    @Autowired
    private StaveRepository _staveRepository;
    private UserRepository _userRepository;

    public ResponseEntity<?> vote(VoteAdapter userRequest) {
        try {
            var stave = _staveRepository.getById(userRequest.staveId);

            if (stave == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stave not found!");
            }

            if (LocalDateTime.now().isBefore(stave.getExpireDate())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Stave expired!");
            }

            var user = _userRepository.getById(userRequest.userId);

            if (user == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
            }

            if (stave.userIds.contains(user.getId())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already vote in this stave!");
            }

            stave.userIds.add(user.getId());
            stave.votes.add(userRequest.optionVote);

            _staveRepository.update(stave);

            return ResponseEntity.status(HttpStatus.OK).body("Vote accounted!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Internal error!");
        }
    }
}
