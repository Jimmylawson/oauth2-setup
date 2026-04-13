package com.example.additioncalculator;

import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CalResponseDto {
    private BigDecimal result;
}
