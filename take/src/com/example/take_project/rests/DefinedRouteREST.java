package com.example.take_project.rests;

import com.example.take_project.models.DefinedRoute;
import com.example.take_project.services.DefinedRouteServiceInterface;

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

import java.util.List;

@Path("/definedRoute")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class DefinedRouteREST {
    @EJB
    DefinedRouteServiceInterface definedRouteServiceInterface;

    @GET
    @Path("/getall")
    public Response getAll(){
        List<DefinedRoute> routes = definedRouteServiceInterface.getAll();
        return Response.ok(routes).build();
    }

    @GET
    @Path("/id/{id}")
    public Response getById(@PathParam("id") Long id){
        DefinedRoute definedRoute = definedRouteServiceInterface.getById(id);
        if (definedRoute == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(definedRoute).build();
    }

    @POST
    @Path("/addnew")
    public Response addNew(DefinedRoute definedRoute){
        if (definedRoute == null) return Response.status(Response.Status.BAD_REQUEST).build();
        definedRoute.setId(null);
        definedRouteServiceInterface.addNew(definedRoute);
        return Response.ok().build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        if (!definedRouteServiceInterface.checkIfEntityWithIdExists(id)) return Response.status(Response.Status.NOT_FOUND).build();
        definedRouteServiceInterface.delete(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/update")
    public Response update(DefinedRoute definedRoute){
        if (definedRoute == null) return Response.status(Response.Status.BAD_REQUEST).build();
        if (!definedRouteServiceInterface.checkIfEntityWithIdExists(definedRoute.getId())) return Response.status(Response.Status.NOT_FOUND).build();
        definedRouteServiceInterface.update(definedRoute);
        return Response.ok().build();
    }
}
