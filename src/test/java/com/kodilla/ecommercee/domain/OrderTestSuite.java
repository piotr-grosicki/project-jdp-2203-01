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

    @Before
    public void userAndOrder(){
        User user1 = new User();
        Order order1 = new Order();
        Order order2 = new Order();

    }



    @Test
    public void testGetsAllOrders(){

        //Given

        //When
        int result = orderRespository.findAll().size();

        //Then
        assertEquals(2, result);


    }

    @Test
    public void testAddNewOrder(){
        //Given
        Order order = new Order(
                LocalDate.now().minusDays(3),
                LocalDate.now().plusDays(7),
                user,
                new Cart(user)
        );
        //When
        orderRespository.save(order);
        int result = orderRespository.findAll().size();
        //Then
        assertEquals(4, result);
    }

    @Test
    public void testUpdateOrder() {
        //Given
        Order order = new Order(
                LocalDate.now().minusDays(3),
                LocalDate.now().plusDays(7),
                user,
                new Cart(user)
        );

        orderRespository.save(order);
        long orderID = order.getId();

        //When
        Order updateOrder = orderRespository.findById(orderID).get();
        orderRespository.save(updateOrder);
        //Then
        assertEquals(orderRespository.findAllById(orderID));
    }

}