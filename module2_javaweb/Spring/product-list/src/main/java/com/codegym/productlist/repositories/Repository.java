package com.codegym.productlist.repositories;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();
    void save(T t);
    T findById(int id);
    void deleteById(int id);
    List<T> findByName(String name);
}
