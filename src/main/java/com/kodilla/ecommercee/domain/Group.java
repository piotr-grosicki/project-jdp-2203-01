package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.ArrayList;

@NoArgsConstructor
@Entity
@Table(name = "\"GROUPS\"")
public class Group {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "GROUP_ID", unique = true)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    private List<Product> products = new ArrayList<>();
}