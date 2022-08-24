package com.restvote.votingsystem.repository.datajpa;

import com.restvote.votingsystem.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudUserRepository extends JpaRepository<User, Integer> {

    @Override
    Optional<User> findById(Integer id);

    @Override
    List<User> findAll(Sort sort);
}
