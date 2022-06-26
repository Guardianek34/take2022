package com.example.take_project.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class BasicCRUDDaoAbstract<T> implements BasicCRUDDaoInterface<T>{

    @PersistenceContext
    protected EntityManager manager;

    protected final Class<T> entityClass;

    public BasicCRUDDaoAbstract(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    public T getById(Long key) {
        return this.manager.find(entityClass, key);
    }


    public List<T> getAll()
    {
        //System.out.println(entityClass.getName());
        Query q = manager.createQuery("select t from " + entityClass.getSimpleName() + " t");
        @SuppressWarnings("unchecked")
        List<T> entities = q.getResultList();
        return entities;
    }


    public void add(T entity) {
        //System.out.println("Persisting" + entity.toString());
        manager.persist(entity);
    }

    public void update(T entity) {
        entity = this.manager.merge(entity);
    }

    public void delete(Long id) {
        this.manager.remove(this.manager.getReference(entityClass, id));
    }
}
