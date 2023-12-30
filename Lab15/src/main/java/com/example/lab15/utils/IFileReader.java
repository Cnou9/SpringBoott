package com.example.lab15.utils;

import com.example.lab15.model.Car;

import java.util.List;

public interface IFileReader {
    List<Car> readFile(String filePath);

}
