package com.example.take_project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DefinedRoute implements EntityBaseInterface {
    @Id
    @GeneratedValue
    private Long id;

    private String startingLocation;

    private String destination;

    private Integer distanceKM;

    public DefinedRoute() {
    }

    public Long getId() {
        return id;
    }

    public String getStartingLocation() {
        return startingLocation;
    }

    public void setStartingLocation(String startingLocation) {
        this.startingLocation = startingLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getDistanceKM() {
        return distanceKM;
    }

    public void setDistanceKM(Integer distanceKM) {
        this.distanceKM = distanceKM;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
