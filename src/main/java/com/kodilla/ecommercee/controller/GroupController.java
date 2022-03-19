package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.mapper.domain.GroupDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/groups")
public class GroupController {

    @GetMapping
    public ResponseEntity<List<GroupDto>> getGroups() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @PostMapping
    public ResponseEntity<Void> addGroup(@RequestBody GroupDto groupDto) {
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{groupId}")
    public ResponseEntity<GroupDto> getGroup(@PathVariable Long groupId) {
        return ResponseEntity.ok(new GroupDto(1L,"AGD"));
    }

    @PutMapping
    public ResponseEntity<GroupDto> updateGroup(@RequestBody  GroupDto groupDto) {
        return ResponseEntity.ok(new GroupDto(1L, "edited test group"));
    }

}
