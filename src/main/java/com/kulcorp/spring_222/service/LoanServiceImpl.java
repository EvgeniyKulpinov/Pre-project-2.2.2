package com.kulcorp.spring_222.service;

import com.kulcorp.spring_222.model.User;
import com.kulcorp.spring_222.property.UserProperties;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {
    private final UserService userService;

    private final UserProperties properties;

    public LoanServiceImpl(UserService userService, UserProperties properties) {
        this.userService = userService;
        this.properties = properties;
    }

    @Override
    public String creditCalculator(Long id) {
        User user = userService.getUserById(id);
        int carPrise = 0;
        if (user.getCar() != null) {
            carPrise = user.getCar().getPrice();
        }
        if (userService.IncomeClient(id) > properties.getMinIncome() ||
                carPrise > properties.getMinPriseCar()) {
            int value1 = userService.IncomeClient(id) * properties.getHalfAnnualIncome();
            int value2 = (int) (carPrise * properties.getCoeffCostCar());
            if (value1 > value2) {
                return "Сумма кредита: " + value1;
            }
            return "Сумма кредита: " + value2;
        }
        return "Кредит не одобрен";
    }
}
