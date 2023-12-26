package com.example.demostreamapi.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    private int id;
    private String fullname;
    private String job;
    private String gender;
    private String city;
    private int salary;
    private LocalDate birthday;
}
