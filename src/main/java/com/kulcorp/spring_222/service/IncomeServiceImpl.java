package com.kulcorp.spring_222.service;

import com.kulcorp.spring_222.dto.UserDto;
import com.kulcorp.spring_222.property.LoanProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.NoSuchElementException;
@Service
public class IncomeServiceImpl implements IncomeService {

    private final RestTemplate restTemplate;

    private final LoanProperties properties;

    public IncomeServiceImpl(RestTemplate restTemplate, LoanProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }

    public double getIncome(long userId) {
        try {
            UserDto[] usres = restTemplate.getForObject(properties.getUrl(), UserDto[].class);
            return Arrays.stream(usres)
                    .filter(p -> p.getId().equals(userId))
                    .findFirst()
                    .get()
                    .getIncome();
        } catch (NoSuchElementException e) {
            return 0;
        }
    }
}
