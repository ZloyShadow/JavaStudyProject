package com.restvote.votingsystem.repository;

import com.restvote.votingsystem.model.MenuItem;

import java.util.List;

public interface MenuItemRepository extends DataRepository<MenuItem> {

    List<MenuItem> getByRestaurant(int restaurantId);

    MenuItem save(MenuItem menuItem);

    boolean delete(int id);
}
