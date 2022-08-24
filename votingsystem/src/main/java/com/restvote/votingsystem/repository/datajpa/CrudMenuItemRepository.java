package com.restvote.votingsystem.repository.datajpa;

import com.restvote.votingsystem.model.MenuItem;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudMenuItemRepository extends JpaRepository<MenuItem, Integer> {

    @Override
    Optional<MenuItem> findById(Integer id);

    @Override
    List<MenuItem> findAll(Sort sort);

    @Query("SELECT m FROM MenuItem m WHERE m.restaurant.id=:restaurantId ORDER BY m.id ASC")
    List<MenuItem> getByRestaurant(@Param("restaurantId") int restaurantId);

    @Override
    @Transactional
    MenuItem save(MenuItem menuItem);

    @Transactional
    @Modifying
    @Query("DELETE FROM MenuItem m WHERE m.id=:id")
    int delete(@Param("id") int id);
}
