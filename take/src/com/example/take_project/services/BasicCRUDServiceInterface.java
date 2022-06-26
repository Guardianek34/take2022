package com.example.take_project.services;

import com.example.take_project.otherstuff.exceptions.EntityNotFoundException;
import com.example.take_project.otherstuff.exceptions.InvalidUpdateEntityDataException;

import java.util.List;

public interface BasicCRUDServiceInterface<T> {
    T getById(Long id);
    List<T> getAll();
    void addNew(T cp);
    void update(T cp);
    void delete(Long id);
    boolean checkIfEntityWithIdExists(Long id);
}
