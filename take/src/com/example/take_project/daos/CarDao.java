package com.example.take_project.daos;

import javax.ejb.Stateless;

import com.example.take_project.models.Car;

@Stateless
public class CarDao extends BasicCRUDDaoAbstract<Car> implements CarDaoInterface {

    public CarDao() {
        super(Car.class);
    }

}
