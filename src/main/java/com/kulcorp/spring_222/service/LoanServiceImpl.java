package com.kulcorp.spring_222.service;

import com.kulcorp.spring_222.model.User;
import com.kulcorp.spring_222.property.UserProperties;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {
    private final UserService userService;

    private final IncomeService incomeService;

    private final UserProperties properties;

    public LoanServiceImpl(UserService userService, UserProperties properties,IncomeService incomeService) {
        this.userService = userService;
        this.properties = properties;
        this.incomeService = incomeService;
    }

    @Override
    public String creditCalculator(long id) {
        User user = userService.getUserById(id);
        int carPrise = 0;
        if (user.getCar() != null) {
            carPrise = user.getCar().getPrice();
        }
        if (incomeService.getIncome(id) > properties.getMinIncome() ||
                carPrise > properties.getMinPriseCar()) {
            double value1 = incomeService.getIncome(id) * properties.getHalfAnnualIncome();
            double value2 = (carPrise * properties.getCoeffCostCar());
            if (value1 > value2) {
                return "Сумма кредита: " + value1;
            }
            return "Сумма кредита: " + value2;
        }
        return "Кредит не одобрен";
    }
}
