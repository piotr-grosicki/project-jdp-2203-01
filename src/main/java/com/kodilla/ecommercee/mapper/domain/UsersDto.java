package com.kodilla.ecommercee.mapper.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class UsersDto {
    private Long id;
    private String login;
    private Integer phoneNumber;
    private String email;
    private String address;
}
