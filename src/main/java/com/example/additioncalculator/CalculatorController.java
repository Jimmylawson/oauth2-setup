package com.example.additioncalculator;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/calculator")
@RequiredArgsConstructor

@CrossOrigin(origins = "http://localhost:5173")
public class CalculatorController {
    private final CalculatorService calculatorService;

    @PostMapping("/add")
    public ResponseEntity<CalResponseDto> addCalculation(@RequestParam BigDecimal v1 , @RequestParam BigDecimal v2, @AuthenticationPrincipal Jwt jwt){
        var userSub = jwt.getSubject();
            return ResponseEntity.status(HttpStatus.CREATED).body(calculatorService.addValues(v1,v2,userSub));
    }
}
