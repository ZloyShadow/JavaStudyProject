package com.restvote.votingsystem.service;

import com.restvote.votingsystem.model.Restaurant;
import com.restvote.votingsystem.model.Vote;
import javassist.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface VoteService {

    List<Vote> getAll();

    Vote get(int userId, LocalDate date) throws NotFoundException;

    void delete(int userId, LocalDate date) throws NotFoundException;

    Vote save(Restaurant restaurant, int userId) throws NotFoundException;
}
