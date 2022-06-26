package com.example.take_project.daos;

import com.example.take_project.models.Client;
import com.example.take_project.models.ClientPackage;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class ClientPackageDao extends BasicCRUDDaoAbstract<ClientPackage>
        implements ClientPackageDaoInterface {

    public ClientPackageDao() {
        super(ClientPackage.class);
    }

    @Override
    public List<ClientPackage> getAllOwnedBy(Client owner)
    {
        Query query = manager.createQuery("select cp from ClientPackage cp where cp.packageOwner = :owner");
        query.setParameter("owner", owner);
        return query.getResultList();
    }

}
