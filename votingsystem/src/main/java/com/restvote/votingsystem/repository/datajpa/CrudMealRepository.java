package com.restvote.votingsystem.repository.datajpa;

import com.restvote.votingsystem.model.Meal;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudMealRepository extends JpaRepository<Meal, Integer> {

    @Override
    Optional<Meal> findById(Integer id);

    @Override
    List<Meal> findAll(Sort sort);
}
