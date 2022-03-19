package com.kodilla.ecommercee.mapper.domain;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private BigDecimal totalCost;
    private LocalDate creationDate;
    private boolean orderConfirmation;


}
