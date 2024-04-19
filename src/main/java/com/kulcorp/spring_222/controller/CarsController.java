package com.kulcorp.spring_222.controller;

import com.kulcorp.spring_222.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class CarsController {

    private CarService service;

    @RequestMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count,
                          @RequestParam(value = "sortBy", required = false, defaultValue = "id") String property,
                          Model model) {
        model.addAttribute("cars", service.getAllLimited(count, property));
        return "cars";
    }
}