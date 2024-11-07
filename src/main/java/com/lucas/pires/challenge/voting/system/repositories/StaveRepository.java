package com.lucas.pires.challenge.voting.system.repositories;

import com.lucas.pires.challenge.voting.system.dtos.StaveDto;
import com.lucas.pires.challenge.voting.system.repositories.interfaces.IStaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StaveRepository {
    @Autowired
    private IStaveRepository _iStaveREpository;

    public StaveDto create(StaveDto stave) {
        return _iStaveREpository.save(stave);
    }
}
