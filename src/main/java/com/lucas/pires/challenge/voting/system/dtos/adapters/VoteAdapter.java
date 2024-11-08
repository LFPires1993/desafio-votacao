package com.lucas.pires.challenge.voting.system.dtos.adapters;

import com.lucas.pires.challenge.voting.system.utils.enums.VoteOptions;
import io.swagger.v3.oas.annotations.media.Schema;

public class VoteAdapter {
    public int staveId;
    public int userId;

    @Schema(example = "YES | NO")
    public String optionVote;
}