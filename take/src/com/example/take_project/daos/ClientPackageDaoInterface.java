package com.example.take_project.daos;

import com.example.take_project.models.Client;
import com.example.take_project.models.ClientPackage;

import java.util.List;

public interface ClientPackageDaoInterface extends BasicCRUDDaoInterface<ClientPackage> {
    List<ClientPackage> getAllOwnedBy(Client owner);
}
