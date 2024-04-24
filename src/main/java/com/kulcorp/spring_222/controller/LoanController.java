package com.kulcorp.spring_222.controller;

import com.kulcorp.spring_222.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class LoanController {

    private LoanService service;

    @RequestMapping(value = "/loan")
    @ResponseBody
    public double creditCalculator(@RequestParam(value = "userId", required = false) Long id) {
        return service.creditCalculator(id);
    }
}
