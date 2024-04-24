package com.kulcorp.spring_222.service;

import com.kulcorp.spring_222.dao.UserRepository;
import com.kulcorp.spring_222.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }


}