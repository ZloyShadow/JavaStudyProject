package com.restvote.votingsystem.service.implementations;

import com.restvote.votingsystem.AuthorizedUser;
import com.restvote.votingsystem.model.Restaurant;
import com.restvote.votingsystem.model.Vote;
import com.restvote.votingsystem.repository.VoteRepository;
import com.restvote.votingsystem.service.VoteService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.restvote.votingsystem.model.Role.USER;
import static com.restvote.votingsystem.util.ValidationUtil.*;

@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository repository;

    @Autowired
    public VoteServiceImpl(VoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Vote> getAll() {
        return sortById(repository.getAll());
    }

    @Override
    public Vote get(int userId, LocalDate date) throws NotFoundException {
        return checkNotFoundWithId(repository.get(userId, date), userId);
    }

    @Override
    public void delete(int userId, LocalDate date) throws NotFoundException {
        checkRole(AuthorizedUser.getRole(), USER);
        checkNotFoundWithId(repository.delete(userId, date), userId);
    }

    @Override
    public Vote save(Restaurant restaurant, int userId) throws NotFoundException {
        checkRole(AuthorizedUser.getRole(), USER);
        LocalDateTime taken = LocalDateTime.now();
        checkVoteTimeLimit(taken);
        if (repository.get(userId, taken.toLocalDate()) != null) {
            delete(userId, taken.toLocalDate());
        }
        Vote newVote = new Vote(null, restaurant, null, taken);
        return repository.save(newVote, userId);
    }

    private List<Vote> sortById(List<Vote> unsorted) {
        return unsorted.stream()
                .sorted(Comparator.comparing(Vote::getId))
                .collect(Collectors.toList());
    }
}
