package com.kulcorp.spring_222.service;

import com.kulcorp.spring_222.property.UserProperties;
import com.kulcorp.spring_222.dao.UserRepository;
import com.kulcorp.spring_222.model.Car;
import com.kulcorp.spring_222.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

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
    public void add(List<Car> cars) {
        User[] users = restTemplate
                .getForObject(properties.getUrl(), User[].class);
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
    public int IncomeClient(Long id) {
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(properties.getUrl(), Object[].class);
        Object[] objects = responseEntity.getBody();
        String[] strings = Arrays.stream(objects)
                .filter(p -> p.toString().contains("id=" + id))
                .findFirst()
                .get()
                .toString()
                .split("income=");
        return Integer.parseInt(strings[1].replace("}", ""));
    }
}