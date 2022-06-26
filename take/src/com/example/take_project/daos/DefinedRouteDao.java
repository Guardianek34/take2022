package com.example.take_project.daos;

import javax.ejb.Stateless;

import com.example.take_project.models.DefinedRoute;

@Stateless
public class DefinedRouteDao extends BasicCRUDDaoAbstract<DefinedRoute>
        implements DefinedRouteDaoInterface{

    public DefinedRouteDao() {
        super(DefinedRoute.class);
    }
}
