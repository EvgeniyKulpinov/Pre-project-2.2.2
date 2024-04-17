package com.kulcorp.spring_222.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "cars")
@Data
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String carBrand;

    private String color;

    private String licensePlate;

    public Car(String carBrand, String color, String licensePlate) {
        this.carBrand = carBrand;
        this.color = color;
        this.licensePlate = licensePlate;
    }
}
