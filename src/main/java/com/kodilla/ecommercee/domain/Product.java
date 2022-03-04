package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


//Encja stworzona jako stub do momentu uploadu zadania JDP220301-12
@NoArgsConstructor
@Getter
@Setter
@Entity (name = "PRODUCTS")
public class Product {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "PRODUCT_ID", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;
}