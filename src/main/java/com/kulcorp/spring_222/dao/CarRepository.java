package com.kulcorp.spring_222.dao;

import com.kulcorp.spring_222.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    Page<Car> findAll(Pageable pageable);
}
