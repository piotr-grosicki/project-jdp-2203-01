package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {
    private final OrderDto orderDto = OrderDto.builder()
                                              .id(1L)
                                              .totalCost(new BigDecimal(100))
                                              .creationDate(LocalDate.now())
                                              .orderConfirmation(true)
                                              .build();
/*
    private final DbService service;
    private final OrderMapper mapper;

    public OrderController(DbService service, OrderMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }
*/

    @RequestMapping(method = RequestMethod.GET, value = "/orders")
    public ResponseEntity<List<OrderDto>> getOrders() {
        /*
        List<Order> orders = service.getOrders();
        return new ResponseEntity<>(mapper.toDtoList(orders), HttpStatus.OK);
        */
        return new ResponseEntity<>(Stream.of(orderDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/order/{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long orderId) {
        /*
        Order order = service.getOrderById(orderId);
        return new ResponseEntity<>(mapper.toOrderDto(order), HttpStatus.OK);
        */
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/order", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto newOrderDto) {
        /*
        Order order = mapper.toOrderDto(newOrderDto);
        OrderDto savedOrderDto = service.saveOrder(order);
        return new new ResponseEntity<>(savedOrderDto, HttpStatus.OK);
        */
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/order")
    public ResponseEntity<Void> updateOrder(@RequestBody OrderDto updatedOrderDto) {
        /*
        Order order = mapper.toOrderDto(updatedOrderDto);
        service.saveOrder(order);
        */
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/order/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        /*
            service.removeOrder(orderId);
        */
        return ResponseEntity.ok().build();
    }
}
