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
@Table(name = "USERS")
public class User {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PHONE_NUMBER")
    private int phoneNumber;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ADDRESS")
    private String address;
    @OneToMany (targetEntity = Order.class,
                mappedBy = "user",
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

}
