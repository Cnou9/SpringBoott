package com.example.lab15.service;

import com.example.lab15.model.Car;
import com.example.lab15.repository.CarRepository;

import java.util.List;

public class CarService implements CarServiceImpl
{
    private CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.getAllCars();
    }

    @Override
    public Car getCarById(Integer id) {
        return carRepository.getCarById(id);
    }
}
