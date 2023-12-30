package com.example.lab15.database;

import com.example.lab15.utils.IFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitData implements CommandLineRunner {
    @Autowired
    private IFileReader iFileReader;

    @Override
    public void run(String... args) throws Exception {
        CarDB.carList=iFileReader.readFile("car.csv");
        System.out.println("Car size: "+ CarDB.carList.size());
    }
}
