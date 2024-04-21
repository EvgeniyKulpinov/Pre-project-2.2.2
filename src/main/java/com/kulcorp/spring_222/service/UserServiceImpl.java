package com.kulcorp.spring_222.service;

import com.kulcorp.spring_222.config.UserConfig;
import com.kulcorp.spring_222.dao.UserRepository;
import com.kulcorp.spring_222.model.Car;
import com.kulcorp.spring_222.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;

    private final UserRepository userRepository;

    private final UserConfig config;

    @Autowired
    public UserServiceImpl(RestTemplate restTemplate, UserRepository userRepository, UserConfig config) {
        this.restTemplate = restTemplate;
        this.userRepository = userRepository;
        this.config = config;
    }

    @Override
    public void add(List<Car> cars) {
        User[] users = restTemplate
                .getForObject("https://66055cd12ca9478ea1801f2e.mockapi.io/api/users/income", User[].class);
        assert users != null;
        int i = 0;
        for (User user : users) {
            user.setCar(cars.get(i));
            i++;
        }
        userRepository.saveAll(Arrays.asList(users));
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public String creditCalculator(Long id) {
        User user = getUserById(id);
        if (user.getIncome() > config.getMinIncome() || user.getCar().getPrice() > config.getMinPriseCar()) {
            int value1 = user.getIncome() * 6;
            int value2 = (int) (user.getCar().getPrice() * 0.3);
            if (value1 > value2) {
                return "Сумма кредита: " + value1;
            }
            return "Сумма кредита: " + value2;
        }
        return "Кредит не одобрен";
    }
}
