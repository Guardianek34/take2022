package com.example.take_project.services;

import com.example.take_project.dto.clientpackage.NewRouteCarsDefinedRouteDto;
import com.example.take_project.models.Route;
import java.util.List;
import com.example.take_project.otherstuff.exceptions.EntityNotFoundException;
public interface RouteServiceInterface extends BasicCRUDServiceInterface<Route> {
    public List<Route> getRoutesForCar(Long carId) throws EntityNotFoundException;
    void addNew(NewRouteCarsDefinedRouteDto newRouteCarsDefinedRouteDto) throws EntityNotFoundException;

    List<Route> getRoutesForCarInSpecifiedDay(Long carId, Integer day, Integer month, Integer year) throws EntityNotFoundException;
}
