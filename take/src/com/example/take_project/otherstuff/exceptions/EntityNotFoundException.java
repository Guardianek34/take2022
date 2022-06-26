package com.example.take_project.otherstuff.exceptions;

import com.example.take_project.models.EntityBaseInterface;

public class EntityNotFoundException extends Exception{
    private final Class<? extends EntityBaseInterface> entityClass;

    public EntityNotFoundException(Class<? extends EntityBaseInterface> entityClass){
        super("Unable to find entity of type "+entityClass.getSimpleName());
        this.entityClass = entityClass;
    }
}
