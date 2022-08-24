package com.restvote.votingsystem.repository.datajpa;

import com.restvote.votingsystem.model.Meal;
import com.restvote.votingsystem.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaMealRepository implements MealRepository {

    @Autowired
    private CrudMealRepository crudRepository;

    @Override
    public Meal get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public List<Meal> getAll() {
        return crudRepository.findAll(SORT_ID);
    }
}
