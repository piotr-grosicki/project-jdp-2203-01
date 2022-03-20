package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.controller.exceptions.CartNotFoundException;
import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDbService {

    private final CartRepository cartRepository;

    @Autowired
    public CartDbService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart getCart(final Long cartId) throws CartNotFoundException {
        return cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new);
    }

    public List<Cart> getCarts(final List<Long> cartIds) {
        return cartRepository.findAllById(cartIds);
    }

    public Cart saveCart(final Cart cart) {
        return cartRepository.save(cart);
    }

    public void deleteCart(final Long cartId) throws CartNotFoundException {
        try {
            cartRepository.deleteById(cartId);
        } catch (Exception e) {
            throw new CartNotFoundException();
        }
    }
}
