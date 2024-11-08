package com.lucas.pires.challenge.voting.system.dtos.adapters;

import com.lucas.pires.challenge.voting.system.dtos.StaveDto;
import com.lucas.pires.challenge.voting.system.utils.enums.VoteOptions;

import java.time.LocalDateTime;

public class ResponseFinalizeStave {
    public int id;
    public String title;
    public String description;
    public boolean isExpired;
    public ResultResponse results = new ResultResponse();

    public ResponseFinalizeStave(StaveDto stave) {
        this.id = stave.getId();
        this.title = stave.getTitle();
        this.description = stave.getDescription();
        final LocalDateTime date = LocalDateTime.now();

        this.isExpired = stave.getExpireDate().isBefore(date);

        if(this.isExpired) {
            this.results.totalVotes = stave.votes.size();
            this.results.countYes = (int) stave.votes.stream().filter(vote -> vote == VoteOptions.YES).count();
            this.results.countNo = (int) stave.votes.stream().filter(vote -> vote == VoteOptions.NO).count();
        }
    }
}
