package com.example.lab15.repository;

import com.example.lab15.model.Car;

import java.awt.print.Pageable;
import java.util.List;

public interface CarImpl {
    List<Car> getAllCars();

    Car getCarById(Integer id);

}
