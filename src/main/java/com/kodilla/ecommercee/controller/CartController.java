package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.mapper.domain.CartDto;
import com.kodilla.ecommercee.mapper.domain.ProductDto;
import lombok.RequiredArgsConstructor;
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

    @PostMapping("/{OrderID}")
    public ResponseEntity<Void> createOrderFromCart(@RequestBody Long OrderID) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{idCart}")
    public ResponseEntity<Void> createEmptyCart(@RequestBody Long idCart) {
        return ResponseEntity.ok().build();
    }


}


