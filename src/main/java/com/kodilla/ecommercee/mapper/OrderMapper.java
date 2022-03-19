package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.mapper.domain.Order;
import com.kodilla.ecommercee.mapper.domain.OrderDto;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public Order mapToOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setTotalCost(orderDto.getTotalCost());
        order.setCreationDate(orderDto.getCreationDate());
        order.setOrderConfirmation(orderDto.isOrderConfirmation());
        return order;
    }

    public OrderDto mapToOrderDto(Order order) {
        return new OrderDto(order.getId(),
                order.getTotalCost(),
                order.getCreationDate(),
                order.isOrderConfirmation());

    }

    public List<OrderDto> mapToOrderDtoList(List<Order> order) {
        return order.stream()
                .map(this::mapToOrderDto)
                .collect(Collectors.toList());
    }
}
