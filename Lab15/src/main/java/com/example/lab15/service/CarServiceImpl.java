package com.example.lab15.service;

import com.example.lab15.model.Car;

import java.util.List;

public interface CarServiceImpl {
    List<Car> getAllCars();

    Car getCarById(Integer id);
}
