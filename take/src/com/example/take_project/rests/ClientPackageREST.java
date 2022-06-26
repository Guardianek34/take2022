package com.example.take_project.rests;

import com.example.take_project.dto.clientpackage.NewClientPackageDto;
import com.example.take_project.dto.clientpackage.UpdatedClientPackageDto;
import com.example.take_project.dto.exception.ExceptionDto;
import com.example.take_project.models.Client;
import com.example.take_project.models.ClientPackage;
import com.example.take_project.otherstuff.exceptions.EntityNotFoundException;
import com.example.take_project.services.ClientPackageServiceInterface;

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

@Path("/clientPackage")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class ClientPackageREST {
    @EJB
    ClientPackageServiceInterface clientPackageService;

    @GET
    @Path("/getall")
    public List<ClientPackage> getAll(){
        return clientPackageService.getAll();
    }

    @GET
    @Path("/clientId/{id}")
    public Response getClientsPackages(@PathParam("id") Long ownerID){
        if(ownerID == null) return Response.status(Response.Status.BAD_REQUEST).build();

        try {
            List<ClientPackage> packages = clientPackageService.getAllOwnedByClient(ownerID);
            return Response.ok(packages).build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/id/{id}")
    public Response getById(@PathParam("id") Long id){
        if (id == null) return Response.status(Response.Status.BAD_REQUEST).build();
        ClientPackage cp = clientPackageService.getById(id);
        if (cp == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(cp).build();
    }

    @POST
    @Path("/addnew")
    public Response addNew(NewClientPackageDto clientPackage){
        if (clientPackage == null) return Response.status(Response.Status.BAD_REQUEST).build();
        try {
            clientPackageService.addNew(clientPackage);
            return Response.ok().build();
        }
        catch (EntityNotFoundException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id){
        if (id == null) return Response.status(Response.Status.BAD_REQUEST).build();
        if (!clientPackageService.checkIfEntityWithIdExists(id)) return Response.status(Response.Status.NOT_FOUND).build();
        clientPackageService.delete(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/update")
    public Response update(UpdatedClientPackageDto cp){
        if (cp == null) return Response.status(Response.Status.BAD_REQUEST).build();
        if (!clientPackageService.checkIfEntityWithIdExists(cp.getId())) return Response.status(Response.Status.NOT_FOUND).build();
        try {
            clientPackageService.update(cp);
        }
        catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).entity(new ExceptionDto(e.getMessage())).build();
        }
        return Response.ok().build();
    }
}
