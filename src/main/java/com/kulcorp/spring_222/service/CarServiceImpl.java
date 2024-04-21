package com.kulcorp.spring_222.service;

import com.kulcorp.spring_222.config.CarConfig;
import com.kulcorp.spring_222.dao.CarRepository;
import com.kulcorp.spring_222.exception.AppException;
import com.kulcorp.spring_222.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    private final CarConfig config;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, CarConfig config) {
        this.carRepository = carRepository;
        this.config = config;
    }

    @Override
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @Override
    public void add(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> getAllLimited(Integer count, String sortBy) {
        if (count == null || count > config.getMaxCars() || count == 0) {
            count = config.getMaxCars();
        }
        if (!Arrays.asList(config.getSorting()).contains(sortBy)) {
            throw new AppException();
        }
        Page<Car> page = carRepository.findAll(
                PageRequest.of(0, count, Sort.by(Sort.Order.asc(sortBy))));
        return page.getContent();
    }
}
