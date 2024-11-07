package com.lucas.pires.challenge.voting.system.services;

import com.lucas.pires.challenge.voting.system.dtos.UserDto;
import com.lucas.pires.challenge.voting.system.dtos.adapters.CreateUserAdapter;
import com.lucas.pires.challenge.voting.system.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository _userRepository;

    public ResponseEntity<?> createUser(CreateUserAdapter userRequest) {
        try {
            if(userRequest.cpf.length() != 11) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CPF inválid!");
            }
            System.out.println(userRequest.cpf.length());

            var user = new UserDto(userRequest);

            var userResponse = _userRepository.create(user);

            return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Internal error!");
        }
    }
}
