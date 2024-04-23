package com.kulcorp.spring_222.service;

import com.kulcorp.spring_222.property.CarProperties;
import com.kulcorp.spring_222.dao.CarRepository;
import com.kulcorp.spring_222.exception.SortingException;
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

    private final CarProperties properties;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, CarProperties properties) {
        this.carRepository = carRepository;
        this.properties = properties;
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
        if (count == null || count > properties.getMaxCars() || count == 0) {
            count = properties.getMaxCars();
        }
        if (!Arrays.asList(properties.getSorting()).contains(sortBy)) {
            throw new SortingException();
        }
        Page<Car> page = carRepository.findAll(
                PageRequest.of(0, count, Sort.by(Sort.Order.asc(sortBy))));
        return page.getContent();
    }
}
