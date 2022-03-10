package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/carts")
@RequiredArgsConstructor
public class CartController {
    @GetMapping("/{idCart}")
    public ResponseEntity<List<ProductDto>> getProductsFromCart(@PathVariable Long idCart) {
        return ResponseEntity.ok(new ArrayList<>());
    }


    @PostMapping("/{idCart}/{idProduct}")
    public ResponseEntity<CartDto> addProductToCart(@PathVariable Long idCart, @PathVariable Long idProduct) {
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{idCart}/{idProduct}")
    public ResponseEntity<CartDto> deleteProductFromCart(@PathVariable Long idCart, @PathVariable Long idProduct) {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> createOrderFromCart(@PathVariable Long OrderID) {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> createEmptyCart(@PathVariable Long idCart) {
        return ResponseEntity.ok().build();
    }


}


