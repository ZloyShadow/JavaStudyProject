package com.restvote.votingsystem.service.implementations;

import com.restvote.votingsystem.model.Restaurant;
import com.restvote.votingsystem.repository.RestaurantRepository;
import com.restvote.votingsystem.service.RestaurantService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.restvote.votingsystem.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Restaurant get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Cacheable("restaurants")
    @Override
    public List<Restaurant> getAll() {
        return repository.getAll().stream()
                .sorted(Comparator.comparing(Restaurant::getId))
                .collect(Collectors.toList());
    }
}
