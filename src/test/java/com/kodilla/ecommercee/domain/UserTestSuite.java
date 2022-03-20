package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class UserTestSuite {

    @Autowired
    UserRepository userRepository;
    User user = new User();

    @Autowired
    CartRepository cartRepository;

    @Autowired
    OrderRepository orderRepository;

    @BeforeEach
    public void prepareTests() {
        user.setLogin("test");
        user.setPhoneNumber(629714902);
        user.setEmail("test@gmail.com");
        user.setAddress("test address");
    }

    @Test
    public void findUserByAllFieldsTest() {
        //Given
        //When
        userRepository.save(user);
        //Then
        Assertions.assertTrue(userRepository.findById(user.getId()).isPresent());
        Assertions.assertTrue(userRepository.findByAddress(user.getAddress()).isPresent());
        Assertions.assertTrue(userRepository.findByEmail(user.getEmail()).isPresent());
        Assertions.assertTrue(userRepository.findByLogin(user.getLogin()).isPresent());
        Assertions.assertTrue(userRepository.findByPhoneNumber(user.getPhoneNumber()).isPresent());
        //CleanUp
        userRepository.deleteById(user.getId());
    }

    @Test
    public void findUsersTest() {
        //Given
        User secondUser = new User();
        secondUser.setLogin("test");
        secondUser.setPhoneNumber(629714902);
        secondUser.setEmail("test@gmail.com");
        secondUser.setAddress("test address");
        //When
        userRepository.save(user);
        userRepository.save(secondUser);
        //Then
        Assertions.assertEquals(2, userRepository.findAll().size());
        //CleanUp
        userRepository.deleteById(user.getId());
        userRepository.deleteById(secondUser.getId());
    }

}