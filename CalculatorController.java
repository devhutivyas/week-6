package com.busyqa.course.controller;

import java.math.BigDecimal;
import java.math.MathContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @GetMapping({"/","/calculate"})
    public String init() {

        System.out.println("Showing Calculator!!!");

        return "calculator";
    }

    @PostMapping("/calculate")
    public ModelAndView show(@RequestParam("ope1") BigDecimal ope1, 
    		                 @RequestParam("ope2") BigDecimal ope2,
                             @RequestParam("operation") String operation) {

        BigDecimal result = BigDecimal.ZERO;

        switch (operation) {
        case "+":
            result = ope1.add(ope2);
            break;
        case "-":
            result = ope1.subtract(ope2);
            break;
        case "*":
            result = ope1.multiply(ope2);
            break;
        case "/":
            result = ope1.divide(ope2, MathContext.DECIMAL128);
            break;
        default:
            throw new RuntimeException("Invalid Operation!!!");
        }

        System.out.printf("Calculation Performed : %s !!!!%n",result);

        return new ModelAndView("calculator","result",result);
    }
}
