package com.kodilla.ecommercee.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
@Table(name = "ORDERS")
public class Order {

    private Long id;
    private BigDecimal totalCost;
    private LocalDate creationDate;
    private boolean orderConfirmation;
    private User user;
    private Cart cart;
    private List<Product> products = new ArrayList<>();

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ORDER_ID", unique = true)
    public Long getId() {
        return id;
    }

    @NotNull
    @Column(name = "TOTAL_COST")
    public BigDecimal getTotalCost() {
        return totalCost;
    }

    @NotNull
    @Column(name = "CREATION_DATE")
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @NotNull
    @Column(name = "ORDER_CONFIRMATION")
    public boolean getOrderConfirmation() {
        return orderConfirmation;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "CART_ID")
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_ORDERS_WITH_PRODUCTS",
            joinColumns = {@JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")}
    )
    public List<Product> getProducts() {
        return new ArrayList<>();
    }

    private void setProducts(List<Product> products) {
        this.products = products;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    private void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    private void setOrderConfirmation(boolean orderConfirmation) {
        this.orderConfirmation = orderConfirmation;
    }

}

