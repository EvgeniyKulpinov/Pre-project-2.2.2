package com.kulcorp.spring_222.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String carBrand;

    private int price;

    private String licensePlate;

    @OneToOne(mappedBy = "car")
    private User user;

    public Car(String carBrand, int price, String licensePlate) {
        this.carBrand = carBrand;
        this.price = price;
        this.licensePlate = licensePlate;
    }
}
