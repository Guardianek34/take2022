package com.example.take_project.daos;

import java.util.List;

public interface BasicCRUDDaoInterface<T> {
    void add(T entity);
    T getById(Long key);
    List<T> getAll();
    void delete(Long id);
    void update(T entity);
}
