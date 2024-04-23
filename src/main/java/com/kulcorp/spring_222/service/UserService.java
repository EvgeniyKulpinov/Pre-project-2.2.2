package com.kulcorp.spring_222.service;

import com.kulcorp.spring_222.model.Car;
import com.kulcorp.spring_222.model.User;

import java.util.List;

public interface UserService {
    void add(List<Car> cars);

    User getUserById(Long id);

    int IncomeClient(Long id);
}
