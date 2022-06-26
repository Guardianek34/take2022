package com.example.take_project.rests;

import com.example.take_project.models.Car;
import com.example.take_project.services.CarServiceInterface;

import java.security.Principal;
import java.util.List;

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

@Path("/car")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class CarREST {
    @EJB
    CarServiceInterface carService;

    @Context
    SecurityContext securityContext;

    @GET
    @Path("/getall")
    public Response getAll(){
//        Principal principal = securityContext.getUserPrincipal();
//        String userName = principal.getName();
        List<Car> cars = carService.getAll();
        return Response.ok(cars).build();
    }

    @GET
    @Path("/id/{id}")
    public Response getById(@PathParam("id") Long id){
        if (id == null) return Response.status(Response.Status.BAD_REQUEST).build();
        Car c = carService.getById(id);
        if (c == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(c).build();
    }

    @POST
    @Path("/addnew")
    public Response addNew(Car car){
        if (car == null) return Response.status(Response.Status.BAD_REQUEST).build();
        car.setId(null);
        carService.addNew(car);
        return Response.ok().build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id){
        if (id == null) return Response.status(Response.Status.BAD_REQUEST).build();
        if (!carService.checkIfEntityWithIdExists(id)) return Response.status(Response.Status.NOT_FOUND).build();
        carService.delete(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/update")
    public Response update(Car car){
        if (car == null) return Response.status(Response.Status.BAD_REQUEST).build();
        if (!carService.checkIfEntityWithIdExists(car.getId())) return Response.status(Response.Status.NOT_FOUND).build();
        carService.update(car);
        return Response.ok().build();
    }


}
