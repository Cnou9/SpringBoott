package com.example.lab15.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Car {
        private Integer id;
        private String name;
        private String description;
        private String thumbnail;
        private Integer price;
        private Double rating;
        private Integer priceDiscount;
    }

