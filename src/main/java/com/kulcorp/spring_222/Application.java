package com.kulcorp.spring_222;

import com.kulcorp.spring_222.model.Car;
import com.kulcorp.spring_222.model.User;
import com.kulcorp.spring_222.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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


        userService.add(new User(new Car("БМВ", 2000000, "А123БВ")));
        userService.add(new User());
        userService.add(new User(new Car("КИА", 1000000, "О765НЕ")));
        userService.add(new User(new Car("Рено", 900000, "Л765ГД")));
        userService.add(new User());
        userService.add(new User());
        userService.add(new User());
        userService.add(new User(new Car("Хёндай", 800000, "А999УЕ")));
        userService.add(new User(new Car("Лада", 600000, "Б343ГД")));
        userService.add(new User(new Car("Хонда", 1500000, "С836ША")));
    }
}
