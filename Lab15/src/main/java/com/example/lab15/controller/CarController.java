package com.example.lab15.controller;

import com.example.lab15.model.Car;
import com.example.lab15.repository.CarRepository;
import com.example.lab15.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CarController {
    @Autowired
    private CarRepository carRepository;

    @GetMapping("/")
    public String getHome(Model model){
        return "getHome";
    }

    @GetMapping("/car-list")
    public String getAllCars(Model model) {
        model.addAttribute("cars", carRepository.getAllCars());
        return "car-list";
    }

    @GetMapping("/car-detail/{id}")
    public String getCarDetail(@PathVariable Integer id, Model model) {
        model.addAttribute("cars", carRepository.getCarById(id));
        return "car-detail";
    }
}
