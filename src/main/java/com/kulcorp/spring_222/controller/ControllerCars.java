package com.kulcorp.spring_222.controller;

import com.kulcorp.spring_222.service.CarService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class ControllerCars {

    private CarService service;

    @Value("${key.maxCar}")
    private int maxCar;

    @Autowired
    public ControllerCars(CarService service) {
        this.service = service;
    }

    @RequestMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count,
                          @RequestParam(value = "sortBy", required = false, defaultValue = "id") String property,
                          Model model) {
        if (count == null || count > maxCar || count == 0) {
            model.addAttribute("cars", service.getCars());
            return "cars";
        }
        model.addAttribute("cars", service.getAllLimited(count, property));
        return "cars";
    }
}
