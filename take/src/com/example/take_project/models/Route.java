package com.example.take_project.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = {"packages", "vehicle"})
public class Route implements EntityBaseInterface{
    @Id
    @GeneratedValue
    private Long id;

    private Date date;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST
    )
    private DefinedRoute routeType;

    @ManyToOne(fetch = FetchType.LAZY

            )
    private Car vehicle;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "route"
    )
    private List<ClientPackage> packages;

    public void addPackage(ClientPackage newPackage)
    {
        this.packages.add(newPackage);
        newPackage.setRoute(this);
    }

    public void removePackage(ClientPackage packageToDelete)
    {
        this.packages.remove(packageToDelete);
        packageToDelete.setRoute(null);
    }

    public Route() {
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DefinedRoute getRouteType() {
        return routeType;
    }

    public void setRouteType(DefinedRoute routeType) {
        this.routeType = routeType;
    }

    public Car getVehicle() {
        return vehicle;
    }

    public void setVehicle(Car vehicle) {
        this.vehicle = vehicle;
    }

    public List<ClientPackage> getPackages() {
        return packages;
    }

    public void setPackages(List<ClientPackage> packages) {
        this.packages = packages;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
