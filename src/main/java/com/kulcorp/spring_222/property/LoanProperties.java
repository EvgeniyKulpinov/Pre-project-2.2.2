package com.kulcorp.spring_222.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("loan")
@Data
public class LoanProperties {

    private int minIncome;

    private int minPriceCar;

    private int halfAnnualIncome;

    private Double coeffCostCar;
}
