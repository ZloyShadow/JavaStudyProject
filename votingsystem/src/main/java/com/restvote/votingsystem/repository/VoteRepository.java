package com.restvote.votingsystem.repository;

import com.restvote.votingsystem.model.Vote;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository {

    Vote get(int id, LocalDate date);

    List<Vote> getAll();

    Vote save(Vote vote, int userId);

    boolean delete(int userId, LocalDate date);
}
