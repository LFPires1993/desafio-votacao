package com.lucas.pires.challenge.voting.system.dtos.adapters;

import com.lucas.pires.challenge.voting.system.dtos.StaveDto;

import java.time.LocalDateTime;

public class ResponseAllStaveAdapter {
    public int id;
    public String title;
    public String description;
    public boolean isExpired;

    public ResponseAllStaveAdapter(StaveDto stave) {
        this.id = stave.getId();
        this.title = stave.getTitle();
        this.description = stave.getDescription();

        final LocalDateTime date = LocalDateTime.now();

        this.isExpired = stave.getExpireDate().isBefore(date);
    }
}
