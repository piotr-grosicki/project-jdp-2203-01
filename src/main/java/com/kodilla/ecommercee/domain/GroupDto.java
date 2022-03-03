package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@AllArgsConstructor
public class GroupDto {

    private Long groupId;
    private String groupName;
    private List<Product> products;

}
