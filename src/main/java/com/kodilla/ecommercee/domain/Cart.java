package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "CARTS")
public class Cart {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "CartsHasProducts",
            joinColumns = {@JoinColumn(name = "products_id")},
            inverseJoinColumns = {@JoinColumn(name = "carts_id")}
    )
    private List<Product> productInTheCart = new ArrayList<>();

}
