package com.example.demo1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString


public class Teacher {

    public Teacher(int id, String name) {
        System.out.println("Teacher Constructor");
        this.id = id;
        this.name = name;
    }

    private int id;
    private String name;


    }


