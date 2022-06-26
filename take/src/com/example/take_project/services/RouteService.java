package com.example.take_project.services;

import com.example.take_project.daos.DefinedRouteDaoInterface;
import com.example.take_project.daos.RouteDao;
import com.example.take_project.daos.RouteDaoInterface;
import com.example.take_project.dto.clientpackage.NewRouteCarsDefinedRouteDto;
import com.example.take_project.models.DefinedRoute;
import com.example.take_project.models.Route;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.example.take_project.daos.CarDaoInterface;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import com.example.take_project.models.Car;
import com.example.take_project.otherstuff.exceptions.EntityNotFoundException;
import java.util.stream.Collectors;
import java.sql.Date;
@Stateless
public class RouteService implements RouteServiceInterface{
    @EJB
    RouteDaoInterface routeDao;


    @EJB
    DefinedRouteDaoInterface definedRouteDaoInterface;

    @EJB
    CarDaoInterface carDaoInterface;
    @Override
    public Route getById(Long id) {
        return routeDao.getById(id);
    }

    @Override
    public List<Route> getAll() {
        return routeDao.getAll();
    }


    @Override
    public void addNew(Route cp) {
        routeDao.add(cp);
    }
    @Override
    public void addNew(NewRouteCarsDefinedRouteDto newRouteCarsDefinedRouteDto) throws EntityNotFoundException {
        Route newRoute = new Route();

        Car chosenCar = carDaoInterface.getById(newRouteCarsDefinedRouteDto.getCarId());
        if (chosenCar == null) throw new EntityNotFoundException(Car.class);

        DefinedRoute chosenDefinedRoute = definedRouteDaoInterface.getById(newRouteCarsDefinedRouteDto.getDefinedRouteId());
        if (chosenDefinedRoute == null) throw new EntityNotFoundException(DefinedRoute.class);

        newRoute.setDate((Date) newRouteCarsDefinedRouteDto.getDate());
        newRoute.setRouteType(chosenDefinedRoute);
        newRoute.setVehicle(chosenCar);

        routeDao.add(newRoute);
    }

    @Override
    public List<Route> getRoutesForCarInSpecifiedDay(Long carId, Integer day, Integer month, Integer year) throws EntityNotFoundException {
        if (carId == null) throw new IllegalArgumentException("Car ID cannot be null");
        if (carDaoInterface.getById(carId) == null) throw new EntityNotFoundException(Car.class);
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, day);
        return routeDao.getAll().stream()
	        .filter(route -> route.getVehicle().getId().equals(carId))
	        .filter(route -> route.getDate().compareTo(c.getTime()) == 0)
	        .collect(Collectors.toList());
    }

    @Override
    public void update(Route cp) {
        routeDao.update(cp);
    }

    @Override
    public void delete(Long id) {
        routeDao.delete(id);
    }

    @Override
    public boolean checkIfEntityWithIdExists(Long id) {
        return routeDao.getById(id) != null;
    }

    @Override
    public List<Route> getRoutesForCar(Long carId) throws EntityNotFoundException {
        if (carId == null) throw new IllegalArgumentException("Car ID cannot be null");
        if (carDaoInterface.getById(carId) == null) throw new EntityNotFoundException(Car.class);

        return routeDao.getAll().stream().
        		filter(route -> route.getVehicle().getId().equals(carId)).
        		collect(Collectors.toList());
    }
}
