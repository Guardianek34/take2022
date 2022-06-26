package com.example.take_project.services;

import com.example.take_project.daos.BasicCRUDDaoAbstract;
import com.example.take_project.daos.BasicCRUDDaoInterface;
import com.example.take_project.daos.CarDaoInterface;
import com.example.take_project.models.Car;

import java.security.Principal;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CarService implements CarServiceInterface{
    @EJB
    CarDaoInterface carDao;

    @Override
    public void addNew(Car newCar) {
        carDao.add(newCar);
    }

    @Override
    public Car getById(Long id) {
        return carDao.getById(id);
    }

    @Override
    public List<Car> getAll() {
        return carDao.getAll();
    }

    @Override
    public void delete(Long id) {
        carDao.delete(id);
    }

    @Override
    public boolean checkIfEntityWithIdExists(Long id) {
        return carDao.getById(id) != null;
    }

    @Override
    public void update(Car car) {
        carDao.update(car);
    }
}
