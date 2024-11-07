package com.lucas.pires.challenge.voting.system.dtos;

import com.lucas.pires.challenge.voting.system.dtos.adapters.CreateStaveAdapter;
import com.lucas.pires.challenge.voting.system.utils.enums.VoteOptions;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "stave")
public class StaveDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private LocalDateTime expireDate;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    public List<Integer> userIds;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    public List<VoteOptions> votes;

    public StaveDto(CreateStaveAdapter staveRequest) {
        this.title = staveRequest.title;
        this.description = staveRequest.description;

        var date = LocalDateTime.now();

        this.expireDate = date.plusMinutes(staveRequest.minutesDuration);

        this.userIds = new ArrayList<Integer>();
        this.votes = new ArrayList<VoteOptions>();
    }
}
