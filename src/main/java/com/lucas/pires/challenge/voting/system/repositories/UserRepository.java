package com.lucas.pires.challenge.voting.system.repositories;

import com.lucas.pires.challenge.voting.system.dtos.UserDto;
import com.lucas.pires.challenge.voting.system.repositories.interfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private IUserRepository _iUserREpository;

    public UserDto create(UserDto user) {
        var userResponse = _iUserREpository.findByCpf(user.getCpf());

        if (userResponse instanceof UserDto) {
           return userResponse;
        }

        return _iUserREpository.save(user);
    }
}
