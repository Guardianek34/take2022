package com.example.take_project.services;

import com.example.take_project.daos.ClientDaoInterface;
import com.example.take_project.models.Client;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import java.util.List;

@Stateless
public class ClientService implements ClientServiceInterface{
    @EJB
    ClientDaoInterface clientDao;

    @Override
    public Client getById(Long id) {
        return clientDao.getById(id);
    }



    @Override
    public List<Client> getAll() {
        return clientDao.getAll();
    }

    @Override
    public void addNew(Client cp) {
        clientDao.add(cp);
    }

    @Override
    public void update(Client cp) {
        clientDao.update(cp);
    }

    @Override
    public void delete(Long id) {
        clientDao.delete(id);
    }

    @Override
    public boolean checkIfEntityWithIdExists(Long id) {
        return clientDao.getById(id) != null;
    }
}
