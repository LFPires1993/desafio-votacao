package com.lucas.pires.challenge.voting.system.repositories.interfaces;

import com.lucas.pires.challenge.voting.system.dtos.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserDto, Long> {
    UserDto findByCpf(String cpf);
}
