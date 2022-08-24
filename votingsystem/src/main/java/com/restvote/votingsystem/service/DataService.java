package com.restvote.votingsystem.service;

import javassist.NotFoundException;

import java.util.List;

public interface DataService<T> {

    T get(int id) throws NotFoundException;

    List<T> getAll();
}
