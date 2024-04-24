package com.kulcorp.spring_222.service;

import com.kulcorp.spring_222.dto.DtoUser;
import com.kulcorp.spring_222.property.UserProperties;
import com.kulcorp.spring_222.dao.UserRepository;
import com.kulcorp.spring_222.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;

    private final UserRepository userRepository;

    private final UserProperties properties;

    @Autowired
    public UserServiceImpl(RestTemplate restTemplate, UserRepository userRepository, UserProperties properties) {
        this.restTemplate = restTemplate;
        this.userRepository = userRepository;
        this.properties = properties;
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public int IncomeClient(Long id) {
        try {
            DtoUser[] usres = restTemplate.getForObject(properties.getUrl(), DtoUser[].class);
            return Arrays.stream(usres)
                    .filter(p -> p.getId().equals(id))
                    .findFirst()
                    .get()
                    .getIncome();
        } catch (NoSuchElementException e) {
            return 0;
        }
    }
}