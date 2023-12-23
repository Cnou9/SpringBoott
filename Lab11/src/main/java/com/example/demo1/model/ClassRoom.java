package com.example.demo1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
* Inject Bean
* C1 Đánh dấu field
* C2 đánh dâu constructor
* C3 đánh dấy setter*/
@Component
@Getter
@Setter
@AllArgsConstructor
@ToString
public class ClassRoom {
    private int id;
    //cách 1
    @Autowired
    private Student student;

    @Autowired
    private Teacher teacher;

    public ClassRoom(){
        System.out.println("ClassRoom constructor");
    }

    //Cách 2
    /*
    private final Student student;
    private final Teacher teacher;
    public ClassRoom(Student student, Teacher teacher) {
        System.out.println("ClassRoom constructor");
        this.student = student;
        this.teacher = teacher;
    }*/
}
