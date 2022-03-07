package com.kodilla.ecommercee.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "carts")
@Table(name = "CARTS")
public class Cart {

    private Long id;
    private List<Order> orders = new ArrayList<>();

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "CART_ID", unique = true)
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Order> getOrders() {
        return new ArrayList<>();
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
