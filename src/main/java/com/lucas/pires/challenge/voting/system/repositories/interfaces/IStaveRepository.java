package com.lucas.pires.challenge.voting.system.repositories.interfaces;

import com.lucas.pires.challenge.voting.system.dtos.StaveDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStaveRepository extends JpaRepository<StaveDto, Long> {
}
