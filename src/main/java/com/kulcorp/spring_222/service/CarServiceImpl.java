package com.kulcorp.spring_222.service;

import com.kulcorp.spring_222.dao.CarRepository;
import com.kulcorp.spring_222.model.Car;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Override
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @Override
    public void add(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> getAllLimited(int count, String property) {
        Page<Car> page = carRepository.findAll(
                PageRequest.of(0, count, Sort.by(Sort.Order.asc(property))));
        return page.getContent();
    }
}
