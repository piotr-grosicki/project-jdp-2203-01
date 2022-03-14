package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.OrderRespository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.transaction.Status;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTestSuite {


    @Autowired
    private OrderRespository orderRespository;

    private UserRepository userRepository;

    private Order order1;
    private Order order2;
    private User user;


    @Before
    public void prepareUsersAndOrders() {

        this.order1 = new Order();

        this.order2 = new Order();

        orderRespository.save(order1);
        orderRespository.save(order2);

    }

    @Test
    public void testGetsAllOrders() {

        //Given

        //When
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
        assertEquals(3, result);
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
        assertEquals(2, orderRespository.findAll().size());
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