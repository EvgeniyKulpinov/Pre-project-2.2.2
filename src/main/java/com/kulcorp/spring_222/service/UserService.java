package com.kulcorp.spring_222.service;

import com.kulcorp.spring_222.model.User;

public interface UserService {
    void add(User user);

    User getUserById(Long id);

    int IncomeClient(Long id);
}
