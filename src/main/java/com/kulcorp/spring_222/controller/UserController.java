package com.kulcorp.spring_222.controller;

import com.kulcorp.spring_222.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class UserController {

    private LoanService service;

    @RequestMapping(value = "/loan")
    public String creditCalculator(@RequestParam(value = "userId", required = false) Long id, Model model) {
        model.addAttribute("credit", service.creditCalculator(id));
        return "credit";
    }
}
