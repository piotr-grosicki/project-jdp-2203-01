package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.domain.UsersDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UsersController {

    @GetMapping
    public ResponseEntity<List<UsersDto>> getUsers() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping(value = "{usersId}")
    public ResponseEntity<UsersDto> getUser(@PathVariable Long usersId) {
        return ResponseEntity.ok(new UsersDto(1L, "user1", "user1@email.com", "100 Main Avenue, Washington DC, Us"));
    }

    @PostMapping
    public ResponseEntity<Void> addUsers(@RequestBody UsersDto usersDto) {
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<UsersDto> updateUser(@RequestBody GroupDto groupDto) {
        return ResponseEntity.ok(new UsersDto(10L, "New user", "myEmail@email.com", "temporary"));
    }

    @DeleteMapping(value = "{usersId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long usersId) {
        return ResponseEntity.ok().build();
    }
}
