package com.example.take_project.services;

import com.example.take_project.otherstuff.exceptions.EntityNotFoundException;
import com.example.take_project.otherstuff.exceptions.InvalidUpdateEntityDataException;

import java.util.List;

public interface BasicCRUDServiceInterfaceTyped<TEntity, TNewEntity, TUpdatedEntity> {
    TEntity getById(Long id);
    List<TEntity> getAll();
    void addNew(TNewEntity cp) throws EntityNotFoundException;
    void update(TUpdatedEntity cp) throws InvalidUpdateEntityDataException, EntityNotFoundException;
    void delete(Long id);
    boolean checkIfEntityWithIdExists(Long id);
}
