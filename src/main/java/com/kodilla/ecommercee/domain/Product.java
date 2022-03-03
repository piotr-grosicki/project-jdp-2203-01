package com.kodilla.ecommercee.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


//Encja stworzona jako stub do momentu uploadu zadania JDP220301-12
@Entity
public class Product {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;
}
