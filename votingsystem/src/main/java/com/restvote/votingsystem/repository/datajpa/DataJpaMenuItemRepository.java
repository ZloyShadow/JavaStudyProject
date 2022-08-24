package com.restvote.votingsystem.repository.datajpa;

import com.restvote.votingsystem.model.MenuItem;
import com.restvote.votingsystem.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaMenuItemRepository implements MenuItemRepository {

    @Autowired
    private CrudMenuItemRepository crudRepository;

    @Override
    public List<MenuItem> getByRestaurant(int restaurantId) {
        return crudRepository.getByRestaurant(restaurantId);
    }

    @Override
    public MenuItem save(MenuItem menuItem) {
        if (!menuItem.isNew() && get(menuItem.getId()) == null) {
            return null;
        }
        return crudRepository.save(menuItem);
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    @Override
    public MenuItem get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public List<MenuItem> getAll() {
        return crudRepository.findAll(SORT_ID);
    }
}
