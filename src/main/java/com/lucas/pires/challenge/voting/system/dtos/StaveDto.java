package com.lucas.pires.challenge.voting.system.dtos;

import com.lucas.pires.challenge.voting.system.dtos.adapters.CreateStaveAdapter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "stave")
public class StaveDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private LocalDateTime expireDate;

    public StaveDto(CreateStaveAdapter staveRequest) {
        this.title = staveRequest.title;
        this.description = staveRequest.description;

        var date = LocalDateTime.now();

        this.expireDate = date.plusMinutes(staveRequest.minutesDuration);
    }
}
