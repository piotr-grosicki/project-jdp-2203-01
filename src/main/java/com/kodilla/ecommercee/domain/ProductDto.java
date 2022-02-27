package com.kodilla.ecommercee.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class ProductDto {
    private String name;
    private Long id;
    private BigDecimal price;
    private Boolean availability;
    private String description;

}
