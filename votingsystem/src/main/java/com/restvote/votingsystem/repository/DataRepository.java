package com.restvote.votingsystem.repository;

import org.springframework.data.domain.Sort;

import java.util.List;

public interface DataRepository<T> {
    Sort SORT_ID = Sort.by(Sort.Direction.ASC, "id");

    T get(int id);

    List<T> getAll();
}
