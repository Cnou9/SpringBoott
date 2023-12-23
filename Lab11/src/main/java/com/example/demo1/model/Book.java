package com.example.demo1.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder // Design Pattern : Builder Pattern (Nhóm khảo tạo)
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    int id;
    String title;
    String author;
    int year;



}
