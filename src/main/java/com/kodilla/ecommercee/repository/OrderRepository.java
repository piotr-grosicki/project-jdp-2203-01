package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Override
    Optional<Order> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    List<Order> findAll();

    @Override
    List<Order> findAllById(Iterable<Long> ids);

    @Override
    Order getOne(Long id);

    @Override
    void delete(Order order);
}