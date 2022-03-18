package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@AllArgsConstructor
public class GroupDto {

    private Long groupId;
    private String groupName;
    private List<Long> productIds;

    public GroupDto(Long id, String name) {
        this.groupId = id;
        this.groupName = name;
    }
}