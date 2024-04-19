package com.kulcorp.spring_222.service;

import com.kulcorp.spring_222.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getCars();

    void add(Car user);

    List<Car> getAllLimited(Integer count, String value);
}
