package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private BigDecimal totalCost;
    private LocalDate creationDate;
    private boolean orderConfirmation;
}
