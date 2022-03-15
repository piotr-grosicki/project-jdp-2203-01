package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Group;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
    @Override
    Optional<Group> findById(Long id);
}
