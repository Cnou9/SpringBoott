package com.example.demostreamapi.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.example.demostreamapi.utils.IFileReader;
@Configuration
public class InitData implements CommandLineRunner {
    @Autowired
    private IFileReader iFileReader;
    @Override
    public void run(String... args) throws Exception {
        PersonDB.personList=iFileReader.readFile("people.csv");
        System.out.println("People size: "+PersonDB.personList.size());
    }
}
