package com.restvote.votingsystem.repository.jpa;

import com.restvote.votingsystem.model.Meal;
import com.restvote.votingsystem.repository.MealRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaMealRepository implements MealRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Meal get(int id) {
        return em.find(Meal.class, id);
    }

    @Override
    public List<Meal> getAll() {
        return em.createNamedQuery(Meal.ALL_SORTED, Meal.class).getResultList();
    }
}
