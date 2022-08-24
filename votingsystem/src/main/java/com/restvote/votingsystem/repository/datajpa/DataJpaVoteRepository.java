package com.restvote.votingsystem.repository.datajpa;

import com.restvote.votingsystem.model.Vote;
import com.restvote.votingsystem.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static com.restvote.votingsystem.repository.DataRepository.SORT_ID;

@Repository
public class DataJpaVoteRepository implements VoteRepository {

    @Autowired
    private CrudVoteRepository crudRepository;

    @Autowired
    private CrudUserRepository crudUserRepository;

    @Override
    public Vote get(int userId, LocalDate date) {
        LocalDateTime startDateTime = date.atStartOfDay();
        return crudRepository.getByUserId(userId, startDateTime, startDateTime.with(LocalTime.MAX));
    }

    @Override
    public List<Vote> getAll() {
        return crudRepository.findAll(SORT_ID);
    }

    @Override
    public Vote save(Vote vote, int userId) {
        if (!vote.isNew() && get(vote.getId(), vote.getTaken().toLocalDate()) == null) {
            return null;
        }
        vote.setUser(crudUserRepository.getOne(userId));
        return crudRepository.save(vote);
    }

    @Override
    public boolean delete(int userId, LocalDate date) {
        LocalDateTime startDateTime = date.atStartOfDay();
        return crudRepository.delete(userId, startDateTime, startDateTime.with(LocalTime.MAX)) != 0;
    }
}
