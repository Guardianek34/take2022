package com.example.take_project.daos;

import javax.ejb.Stateless;

import com.example.take_project.models.Route;

@Stateless
public class RouteDao extends BasicCRUDDaoAbstract<Route>
        implements RouteDaoInterface {

    public RouteDao() {
        super(Route.class);
    }

}
