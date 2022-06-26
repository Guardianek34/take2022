package com.example.take_project.services;

import com.example.take_project.daos.DefinedRouteDaoInterface;
import com.example.take_project.models.DefinedRoute;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import java.util.List;

@Stateless
public class DefinedRouteService implements DefinedRouteServiceInterface{
    @EJB
    DefinedRouteDaoInterface definedRouteDao;

    @Override
    public DefinedRoute getById(Long id) {
        return definedRouteDao.getById(id);
    }

    @Override
    public List<DefinedRoute> getAll() {
        return definedRouteDao.getAll();
    }

    @Override
    public void addNew(DefinedRoute cp) {
        definedRouteDao.add(cp);
    }

    @Override
    public void update(DefinedRoute cp) {
        definedRouteDao.update(cp);
    }

    @Override
    public void delete(Long id) {
        definedRouteDao.delete(id);
    }

    @Override
    public boolean checkIfEntityWithIdExists(Long id) {
        return definedRouteDao.getById(id) != null;
    }
}
