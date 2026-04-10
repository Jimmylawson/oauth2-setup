package com.example.additioncalculator;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @PostMapping("/add")
    public ResponseEntity<CalResponseDto> addCalculation(@RequestParam BigDecimal v1 , @RequestParam BigDecimal v2){

    }
}
