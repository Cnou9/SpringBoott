package com.example.demothymeleaf.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    int id;
    String name;
    String email;
    String phone;
    int score;
}
/*
* /student, /blogs ,/admin
*
* /student/1, /student/2
*
* /student?name ... -> query String
*
* */
