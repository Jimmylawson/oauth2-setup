package com.example.additioncalculator;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculatorService {
    private final CalculatorRepository calculatorRepository;
    public CalResponseDto addValues(BigDecimal v1, BigDecimal v2, String userSub){
        var result = v1.add(v2);

        calculatorRepository.save(
                Calculator.builder()
                        .v1(v1)
                        .v2(v2)
                        .result(result)
                        .userSub(userSub)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return CalResponseDto.builder()
                .result(result)
                .build();
    }
}
