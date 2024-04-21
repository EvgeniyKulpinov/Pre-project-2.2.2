package com.kulcorp.spring_222;

import com.kulcorp.spring_222.model.Car;
import com.kulcorp.spring_222.model.User;
import com.kulcorp.spring_222.service.CarServiceImpl;
import com.kulcorp.spring_222.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestOperations;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final ApplicationContext applicationContext;

    public Application(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        UserServiceImpl userService = applicationContext.getBean(UserServiceImpl.class);
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("БМВ", 2000000, "А123БВ"));
        cars.add(new Car("Лада", 600000, "Б343ГД"));
        cars.add(new Car("КИА", 1000000, "О765НЕ"));
        cars.add(new Car("Рено", 900000, "Л765ГД"));
        cars.add(new Car("Хонда", 1500000, "С836ША"));
        cars.add(new Car("Хёндай", 800000, "А999УЕ"));

        userService.add(cars);
    }
}
