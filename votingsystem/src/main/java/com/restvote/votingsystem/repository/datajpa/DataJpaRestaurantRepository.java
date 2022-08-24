package com.restvote.votingsystem.repository.datajpa;

import com.restvote.votingsystem.model.Restaurant;
import com.restvote.votingsystem.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaRestaurantRepository implements RestaurantRepository {

    @Autowired
    private CrudRestaurantRepository crudRepository;

    @Override
    public Restaurant get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public List<Restaurant> getAll() {
        return crudRepository.findAll(SORT_ID);
    }
}
