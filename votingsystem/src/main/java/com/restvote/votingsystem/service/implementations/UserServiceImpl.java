package com.restvote.votingsystem.service.implementations;

import com.restvote.votingsystem.model.User;
import com.restvote.votingsystem.repository.UserRepository;
import com.restvote.votingsystem.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.restvote.votingsystem.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Cacheable("users")
    @Override
    public List<User> getAll() {
        return repository.getAll().stream()
                .sorted(Comparator.comparing(User::getId))
                .collect(Collectors.toList());
    }
}
