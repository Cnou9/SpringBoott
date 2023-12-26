package com.example.demostreamapi.utils;

import com.example.demostreamapi.model.Person;

import java.util.List;

public interface IFileReader {
    List<Person> readFile(String filePath);
}
