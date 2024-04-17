package com.kulcorp.spring_222;

import com.kulcorp.spring_222.model.Car;
import com.kulcorp.spring_222.service.CarServiceImpl;
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
		CarServiceImpl carService = applicationContext.getBean(CarServiceImpl.class);

		carService.add(new Car("БМВ","Красный","А123БВ"));
		carService.add(new Car("Лада","Синий","Б343ГД"));
		carService.add(new Car("КИА","Белый","О765НЕ"));
		carService.add(new Car("Рено","Чёрный","Л765ГД"));
	}
}
