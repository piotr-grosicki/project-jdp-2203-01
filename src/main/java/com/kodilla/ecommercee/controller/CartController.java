package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;

public class CartController {
    @GetMapping("/{idCart}")
    public ResponseEntity<List<ProductDto>> getProductsFromCart(@PathVariable Long idCart) throws CartNotFoundsExpections {
        return ResponseEntity.ok(new ArrayList<>());
    }


    @PutMapping("addProduct/{idCart}/{idProduct}")
    public ResponseEntity<CartDto> addProductToCart(@PathVariable Long idCart, @PathVariable Long idProduct) throws CartNotFoundsExpections {
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{idCart}/{idProduct}")
    public ResponseEntity<CartDto> deleteProductFromCart(@PathVariable Long idCart, @PathVariable Long idProduct) throws CartNotFoundsExpections {
        return ResponseEntity.ok().build();
    }
}


