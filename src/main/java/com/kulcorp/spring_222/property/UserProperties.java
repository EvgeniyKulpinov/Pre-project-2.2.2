package com.kulcorp.spring_222.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConfigurationProperties("loan")
@Data
public class UserProperties {

    private int minIncome;

    private int minPriseCar;

    private String url;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
