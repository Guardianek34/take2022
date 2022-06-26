package com.example.take_project.rests;

import com.example.take_project.dto.clientpackage.NewRouteCarsDefinedRouteDto;
import com.example.take_project.models.Route;
import com.example.take_project.otherstuff.exceptions.EntityNotFoundException;
import com.example.take_project.services.RouteServiceInterface;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


import com.example.take_project.otherstuff.exceptions.EntityNotFoundException;
import java.util.List;
import com.example.take_project.models.Car;


@Path("/route")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class RouteREST {
    @EJB
    RouteServiceInterface routeServiceInterface;

    @GET
    @Path("/getall")
    public Response getAll(){
        List<Route> routes = routeServiceInterface.getAll();
        return Response.ok(routes).build();
    }

    @GET
    @Path("/id/{id}")
    public Response getById(@PathParam("id") Long id){
        Route route = routeServiceInterface.getById(id);
        if (route == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(route).build();
    }

    @POST
    @Path("/addnew")
    public Response addNew(NewRouteCarsDefinedRouteDto newRouteCarsDefinedRouteDto) throws EntityNotFoundException {
        newRouteCarsDefinedRouteDto.setId(null);
        routeServiceInterface.addNew(newRouteCarsDefinedRouteDto);
        return Response.ok().build();
    }




    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id){
        if (!routeServiceInterface.checkIfEntityWithIdExists(id)) return Response.status(Response.Status.NOT_FOUND).build();
        routeServiceInterface.delete(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/update")
    public Response update(Route route){
        if (route == null) return Response.status(Response.Status.BAD_REQUEST).build();
        if (!routeServiceInterface.checkIfEntityWithIdExists(route.getId())) return Response.status(Response.Status.NOT_FOUND).build();
        routeServiceInterface.update(route);
        return Response.ok().build();
    }

    @GET
    @Path("/forcar/{carId}/")
    public Response getRoutesForCar(@PathParam("carId") Long carId){
        if (carId == null) return Response.status(Response.Status.BAD_REQUEST).build();
        try {
            List<Route> routes = routeServiceInterface.getRoutesForCar(carId);
            return Response.ok(routes).build();
        }
        catch (EntityNotFoundException e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Path("/forcarinday/{carId}/{day}/{month}/{year}")
    public Response getRoutesForCarInSpecifiedDay(@PathParam("carId") Long carId, @PathParam("day") Integer day, @PathParam("month") Integer month, @PathParam("year") Integer year){
        if (carId == null || day == null || month == null || year == null) return Response.status(Response.Status.BAD_REQUEST).build();

        try {
            List<Route> routes = routeServiceInterface.getRoutesForCarInSpecifiedDay(carId, day, month, year);
            return Response.ok(routes).build();
        }
        catch (EntityNotFoundException e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
