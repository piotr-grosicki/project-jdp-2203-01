package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class CartTestSuite {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void findProductsInCartTest() {

        //GIVEN
        Product product1 = new Product("Harry Potter",new BigDecimal(45.5),new Group("Books"));
        Product product2 = new Product("Paintbrush",new BigDecimal(17.45),new Group("Hobby"));
        Product product3 = new Product("Mirror",new BigDecimal(19.99),new Group("Beauty"));
        List<Product> productsInTheCart = new ArrayList<>();
        productsInTheCart.add(product1);
        productsInTheCart.add(product2);
        productsInTheCart.add(product3);
        Long id1 = product1.getId();
        Long id2 = product2.getId();
        Long id3 = product3.getId();

        User user = new User("Maneki Neko");
        Cart cart = new Cart(user);

        //WHEN
        userRepository.save(user);
        cartRepository.save(cart);
        cart.setProductInTheCart(productsInTheCart);

        //THEN
        assertTrue(cart.getProductInTheCart().contains(product1));
        assertEquals(3, productsInTheCart.size());

        //CLEANUP
        cartRepository.deleteById(cart.getId());
        assertTrue(userRepository.findById(user.getId()).isPresent());
        assertEquals(id1,product1.getId());
        assertEquals(id2,product2.getId());
        assertEquals(id3,product3.getId());

    }

    @Test
    public void deleteProductsInCartTest() {

        //GIVEN
        Product product1 = new Product("Harry Potter",new BigDecimal(45.5),new Group("Books"));
        Product product2 = new Product("Paintbrush",new BigDecimal(17.45),new Group("Hobby"));
        Product product3 = new Product("Mirror",new BigDecimal(19.99),new Group("Beauty"));
        List<Product> productsInTheCart = new ArrayList<>();
        productsInTheCart.add(product1);
        productsInTheCart.add(product2);
        productsInTheCart.add(product3);

        User user = new User("Maneki Neko");
        Cart cart = new Cart(user);

        userRepository.save(user);
        cartRepository.save(cart);
        cart.setProductInTheCart(productsInTheCart);

        //WHEN
        productsInTheCart.remove(product1);

        //THEN
        assertFalse(cart.getProductInTheCart().contains(product1));
        assertEquals(2, productsInTheCart.size());

        //CLEANUP
        cartRepository.deleteById(cart.getId());

    }

    @Test
    public void createEmptyCartTest() {

        //GIVEN
        User user = new User("Maneki Neko");
        Cart cart = new Cart(user);

        //WHEN
        userRepository.save(user);
        cartRepository.save(cart);

        //THEN
        assertTrue(cartRepository.findById(cart.getId()).isPresent());
        assertEquals(0,cart.getProductInTheCart().size());

        //CLEANUP
        cartRepository.deleteById(cart.getId());
        assertTrue(userRepository.findById(user.getId()).isPresent());

    }

}
