package com.lucas.pires.challenge.voting.system.dtos;

import com.lucas.pires.challenge.voting.system.dtos.adapters.CreateUserAdapter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String cpf;

    public UserDto(CreateUserAdapter userRequest) {
        this.name = userRequest.name;
        this.cpf = userRequest.cpf;
    }
}
