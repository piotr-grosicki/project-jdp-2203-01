package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.repository.OrderRespository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.time.LocalDate;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTestSuite {


    @Autowired
    private OrderRespository orderRespository;

    @Autowired
    private UserRepository userRepository;

    private User user;
    private User user2;
    private Order order1;
    private Order order2;


    @Test
    public void testGetsAllOrders() {

        //Given
        Order order1 = new Order();
        Order order2 = new Order();
        //When
        orderRespository.save(order1);
        orderRespository.save(order2);
        int result = orderRespository.findAll().size();

        //Then
        assertEquals(2, result);


    }

    @Test
    public void testAddNewOrder() {
        //Given
        Order order = new Order();
        //When
        orderRespository.save(order);
        int result = orderRespository.findAll().size();
        //Then
        assertEquals(4, result);
    }

    @Test
    public void testDeleteOrder() {
        //Given

        Order order = new Order();

        orderRespository.save(order);
        long orderId = order.getId();

        //When
        orderRespository.deleteById(orderId);

        //Then
        assertEquals(3, orderRespository.findAll().size());
        assertFalse(orderRespository.existsById(orderId));
        assertEquals(3, orderRespository.findAll().size());

    }

    @Test
    public void testUpdateOrder() {
        //Given
        Order order = new Order();
        orderRespository.save(order);
        long orderId = order.getId();

        //When
        Order updatedOrder = orderRespository.findById(orderId).get();
        updatedOrder.getId();
        orderRespository.save(updatedOrder);

        //Then
        assertEquals(3, orderRespository.findById(orderId).get());
    }
}