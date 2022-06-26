package com.example.take_project.daos;

import javax.ejb.Stateless;

import com.example.take_project.models.Client;

@Stateless
public class ClientDao extends BasicCRUDDaoAbstract<Client> implements ClientDaoInterface{

    public ClientDao() {
        super(Client.class);
    }

}
