package com.example.take_project.services;

import com.example.take_project.dto.clientpackage.NewClientPackageDto;
import com.example.take_project.dto.clientpackage.UpdatedClientPackageDto;
import com.example.take_project.models.ClientPackage;
import com.example.take_project.otherstuff.exceptions.EntityNotFoundException;

import java.util.List;

public interface ClientPackageServiceInterface extends BasicCRUDServiceInterfaceTyped<ClientPackage, NewClientPackageDto, UpdatedClientPackageDto>{
    List<ClientPackage> getAllOwnedByClient(Long ownerID)
            throws EntityNotFoundException;
}
