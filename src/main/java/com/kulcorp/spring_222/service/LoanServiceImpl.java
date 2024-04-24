package com.kulcorp.spring_222.service;

import com.kulcorp.spring_222.model.User;
import com.kulcorp.spring_222.property.LoanProperties;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {
    private final UserService userService;

    private final IncomeService incomeService;

    private final LoanProperties properties;

    public LoanServiceImpl(UserService userService, LoanProperties properties, IncomeService incomeService) {
        this.userService = userService;
        this.properties = properties;
        this.incomeService = incomeService;
    }

    @Override
    public double creditCalculator(long id) {
        User user = userService.getUserById(id);
        int carPrise = 0;
        if (user.getCar() != null) {
            carPrise = user.getCar().getPrice();
        }
        if (incomeService.getIncome(id) > properties.getMinIncome() ||
                carPrise > properties.getMinPriceCar()) {
            double value1 = incomeService.getIncome(id) * properties.getHalfAnnualIncome();
            double value2 = (carPrise * properties.getCoeffCostCar());
            return Math.max(value1, value2);
        }
        return 0;
    }
}
