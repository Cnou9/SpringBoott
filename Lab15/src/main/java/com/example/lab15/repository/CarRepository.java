package com.example.lab15.repository;

import com.example.lab15.database.CarDB;
import com.example.lab15.model.Car;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CarRepository implements CarImpl{

    @Override
    public List<Car> getAllCars() {
        return CarDB.carList;
    }

    @Override
    public Car getCarById(Integer id) {
        return CarDB.carList.stream()
                .filter(car -> car.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
