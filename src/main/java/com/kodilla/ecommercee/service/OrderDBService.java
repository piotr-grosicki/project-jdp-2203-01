package com.kodilla.ecommercee.service;


import com.kodilla.ecommercee.mapper.domain.Order;
import com.kodilla.ecommercee.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderDBService {

    private final OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order addNewOrder(final Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> findOrder(final Long orderId) {
        return orderRepository.findById(orderId);
    }

    public void deleteOrderById(final Long id) {
        orderRepository.deleteById(id);
    }
}