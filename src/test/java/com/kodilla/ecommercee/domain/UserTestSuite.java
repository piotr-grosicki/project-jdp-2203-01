package com.kodilla.ecommercee.domain;

import static org.junit.Assert.*;

import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTestSuite {

    @Autowired
    UserRepository userRepository;
    public User user = new User();

    @Before
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
        assertTrue(userRepository.findById(user.getId()).isPresent());
        assertTrue(userRepository.findByAddress(user.getAddress()).isPresent());
        assertTrue(userRepository.findByEmail(user.getEmail()).isPresent());
        assertTrue(userRepository.findByLogin(user.getLogin()).isPresent());
        assertTrue(userRepository.findByPhoneNumber(user.getPhoneNumber()).isPresent());
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
        assertEquals(2, userRepository.findAll().size());
        //CleanUp
        userRepository.deleteById(user.getId());
        userRepository.deleteById(secondUser.getId());
    }

}