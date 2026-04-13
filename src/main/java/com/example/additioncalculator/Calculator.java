package com.example.additioncalculator;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="calculator")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Builder
public class Calculator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userSub;
    private BigDecimal v1;
    private BigDecimal v2;
    private BigDecimal result;
    private LocalDateTime createdAt;
}
