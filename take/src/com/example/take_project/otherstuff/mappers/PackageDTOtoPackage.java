package com.example.take_project.otherstuff.mappers;

import com.example.take_project.dto.clientpackage.NewClientPackageDto;
import com.example.take_project.dto.clientpackage.UpdatedClientPackageDto;
import com.example.take_project.models.Client;
import com.example.take_project.models.ClientPackage;
import com.example.take_project.models.Route;

public class PackageDTOtoPackage {

    public ClientPackage map(NewClientPackageDto dto) {
        ClientPackage newClientPackage = new ClientPackage();

        newClientPackage.setDeliveryAddress(dto.getDeliveryAddress());
        newClientPackage.setPrice(dto.getPrice());
        newClientPackage.setPaidFor(dto.getPaidFor());
        newClientPackage.setType(dto.getType());
        newClientPackage.setWeight(dto.getWeight());
        newClientPackage.setEstimatedDeliveryDate(dto.getEstimatedDeliveryDate());

        return newClientPackage;
    }
}
