package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CARTS")
public class Cart {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "CART_ID", unique = true)
    private Long id;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "carts")
    private List<Product> products = new ArrayList<>();
}