package com.restvote.votingsystem.service.implementations;

import com.restvote.votingsystem.model.Meal;
import com.restvote.votingsystem.repository.MealRepository;
import com.restvote.votingsystem.service.MealService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.restvote.votingsystem.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealServiceImpl implements MealService {

    private final MealRepository repository;

    @Autowired
    public MealServiceImpl(MealRepository repository) {
        this.repository = repository;
    }

    @Override
    public Meal get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Cacheable("Meales")
    @Override
    public List<Meal> getAll() {
        return repository.getAll().stream()
                .sorted(Comparator.comparing(Meal::getId))
                .collect(Collectors.toList());
    }
}
