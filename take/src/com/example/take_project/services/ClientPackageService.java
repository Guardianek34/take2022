package com.example.take_project.services;

import com.example.take_project.daos.ClientDaoInterface;
import com.example.take_project.daos.ClientPackageDaoInterface;
import com.example.take_project.daos.RouteDaoInterface;
import com.example.take_project.dto.clientpackage.NewClientPackageDto;
import com.example.take_project.dto.clientpackage.UpdatedClientPackageDto;
import com.example.take_project.models.Client;
import com.example.take_project.models.ClientPackage;
import com.example.take_project.models.Route;
import com.example.take_project.otherstuff.exceptions.EntityNotFoundException;
import com.example.take_project.otherstuff.exceptions.InvalidUpdateEntityDataException;
import com.example.take_project.otherstuff.mappers.PackageDTOtoPackage;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import java.util.List;

@Stateless
public class ClientPackageService implements ClientPackageServiceInterface{
    @EJB
    ClientPackageDaoInterface clientPackageDao;
    @EJB
    ClientDaoInterface clientDaoInterface;
    @EJB
    RouteDaoInterface routeDaoInterface;

    @Override
    public ClientPackage getById(Long id) {
        return clientPackageDao.getById(id);
    }

    @Override
    public List<ClientPackage> getAll() {
        return clientPackageDao.getAll();
    }

    @Override
    public List<ClientPackage> getAllOwnedByClient(Long ownerID)
            throws EntityNotFoundException {
        Client owner = clientDaoInterface.getById(ownerID);
        if(owner == null) throw new EntityNotFoundException(Client.class);

        return clientPackageDao.getAllOwnedBy(owner);
    }


    @Override
    public void addNew(NewClientPackageDto cp) throws EntityNotFoundException {
        ClientPackage newClientPackage = new PackageDTOtoPackage().map(cp);

        Client packageClient = clientDaoInterface.getById(cp.getPackageOwnerId());
        if (packageClient == null) throw new EntityNotFoundException(Client.class);
        newClientPackage.setPackageOwner(packageClient);
        
        if (cp.getPackageRouteId().isPresent()){
            Route packageRoute = routeDaoInterface.getById(cp.getPackageRouteId().get());
            if (packageRoute == null) throw new EntityNotFoundException(Route.class);
            packageRoute.addPackage(newClientPackage);
        }

        clientPackageDao.add(newClientPackage);
    }

    @Override
    public void update(UpdatedClientPackageDto cp) throws InvalidUpdateEntityDataException, EntityNotFoundException {
        ClientPackage clientPackage = clientPackageDao.getById(cp.getId());
        if (cp.getPackageOwnerId() == null) throw new InvalidUpdateEntityDataException("Supplied updated version of client package with no id");
        if (clientPackage.getPackageOwner().getId() != cp.getPackageOwnerId()){
            Client client = clientDaoInterface.getById(cp.getId());
            clientPackage.setPackageOwner(client);
        }

        if (cp.getPackageRouteId().isPresent()){
            Route rt = routeDaoInterface.getById(cp.getPackageRouteId().get());
            if (rt == null) throw new EntityNotFoundException(Route.class);
            clientPackage.setRoute(rt);
        }
        else clientPackage.setRoute(null);

        clientPackage.setType(cp.getType());
        clientPackage.setPrice(cp.getPrice());
        clientPackage.setPaidFor(cp.getPaidFor());
        clientPackage.setDeliveryAddress(cp.getDeliveryAddress());
        clientPackage.setWeight(cp.getWeight());


        clientPackageDao.update(clientPackage);
    }

    @Override
    public void delete(Long id) {
        clientPackageDao.delete(id);
    }

    @Override
    public boolean checkIfEntityWithIdExists(Long id) {
        return clientPackageDao.getById(id) != null;
    }
}
