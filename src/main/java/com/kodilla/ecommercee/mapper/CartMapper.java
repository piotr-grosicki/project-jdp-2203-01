package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.CartDto;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

public class CartMapper {
    @Builder
    public Cart mapToCart(final CartDto cartDto) {
        CartBuilder cartBuilder = new CartBuilder().cartDto(cartDto);
        Cart build = cartBuilder.build();
        return build;
    }

    public CartDto mapToCartDto(final Cart cart) {
        CartDto cartDto = new CartMapper().mapToCartDto(cart);
        return cartDto;
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> cartList) {
        return cartList.stream()
                .map(this::mapToCartDto)
                .collect(Collectors.toList());
    }
}
