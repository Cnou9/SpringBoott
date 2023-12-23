package com.example.demo1.database;

import com.example.demo1.database.BookDB;
import com.example.demo1.utils.CSVFileReader;
import com.example.demo1.utils.ExcelFileReader;
import com.example.demo1.utils.JsonFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

// CommandLineRunner là một interface chạy 1 lần sau khi Spring Boot khởi động
@Configuration
public class InitData implements CommandLineRunner {
//    @Autowired
//    private JsonFileReader jsonFileReader;
//
//    @Override
//    public void run(String... args) throws Exception {
//        BookDB.bookList = jsonFileReader.readFile("MOCK_DATA.json");
//        System.out.println("Book size : " + BookDB.bookList.size());
//    }
    @Autowired
    private ExcelFileReader excelFileReader;

    @Override
    public void run(String... args) throws Exception {
        BookDB.bookList = excelFileReader.readFile("classpath:static/data.xlsx");
        System.out.println("Book size : " + BookDB.bookList.size());
    }


//    @Autowired
//    private CSVFileReader csvFileReader;
//
//    @Override
//    public void run(String... args) throws Exception {
//        BookDB.bookList = csvFileReader.readFile("classpath:static/data.csv");
//        System.out.println("Book size : " + BookDB.bookList.size());
//    }
}