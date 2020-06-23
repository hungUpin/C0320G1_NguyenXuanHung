package service;

import java.util.List;

public interface Service<T> {
    List<T> findAll();
    void save(T t);
//    void update(T t);
    void delete(int id);
    T findById(int id);
    List<T> findByName(String name);
}
