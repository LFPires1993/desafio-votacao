package com.lucas.pires.challenge.voting.system.repositories;

import com.lucas.pires.challenge.voting.system.dtos.UserDto;
import com.lucas.pires.challenge.voting.system.repositories.interfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private IUserRepository _iUserREpository;

    public List<UserDto> getAll() {
        return _iUserREpository.findAll();
    }

    public UserDto getById(int id) {
        return _iUserREpository.findById((long) id).orElse(null);
    }

    public UserDto create(UserDto user) {
        var userResponse = _iUserREpository.findByCpf(user.getCpf());

        if (userResponse instanceof UserDto) {
           return userResponse;
        }

        return _iUserREpository.save(user);
    }
}
