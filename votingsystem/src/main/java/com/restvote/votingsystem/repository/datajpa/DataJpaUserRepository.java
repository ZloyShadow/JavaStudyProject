package com.restvote.votingsystem.repository.datajpa;

import com.restvote.votingsystem.model.User;
import com.restvote.votingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaUserRepository implements UserRepository {

    @Autowired
    private CrudUserRepository crudRepository;

    @Override
    public User get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return crudRepository.findAll(SORT_ID);
    }
}
