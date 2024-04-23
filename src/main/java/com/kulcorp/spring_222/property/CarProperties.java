package com.kulcorp.spring_222.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("car")
@Data
public class CarProperties {

    private int maxCars;

    private String[] sorting;
}
