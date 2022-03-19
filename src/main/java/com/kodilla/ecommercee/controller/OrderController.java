package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.mapper.domain.OrderDto;
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
@RequestMapping("/v1")
public class OrderController {
    private final OrderDto orderDto = OrderDto.builder()
                                              .id(1L)
                                              .totalCost(new BigDecimal(100))
                                              .creationDate(LocalDate.now())
                                              .orderConfirmation(true)
                                              .build();

    @RequestMapping(method = RequestMethod.GET, value = "/orders")
    public ResponseEntity<List<OrderDto>> getOrders() {
        return new ResponseEntity<>(Stream.of(orderDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orders/{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long orderId) {
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/orders", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto newOrderDto) {
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/orders")
    public ResponseEntity<Void> updateOrder(@RequestBody OrderDto updatedOrderDto) {
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/orders/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok().build();
    }
}
