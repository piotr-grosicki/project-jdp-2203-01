package com.kodilla.ecommercee.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CartDto {
    private Long id;
    private List<Long> productIds;
    private Long userId;
}
