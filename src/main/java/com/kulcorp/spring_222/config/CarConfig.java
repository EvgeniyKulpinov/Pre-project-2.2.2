package com.kulcorp.spring_222.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("car")
@Data
public class CarConfig {

    private int maxCars;

    private String[] sorting;
}
