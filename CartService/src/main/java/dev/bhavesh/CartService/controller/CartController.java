/**
 * Copyright (C) 2023 Lokesh Bisht
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */

package dev.lokeshbisht.CartService.controller;

import dev.lokeshbisht.CartService.dto.ApiResponseDto;
import dev.lokeshbisht.CartService.dto.cart.CartDto;
import dev.lokeshbisht.CartService.dto.cart.CartInfoDto;
import dev.lokeshbisht.CartService.model.Cart;
import dev.lokeshbisht.CartService.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/v1")
public class CartController {

    @Autowired
    private CartService cartService;

    public static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @PostMapping("/cart")
    public Cart createCart(@RequestBody CartDto cartDto) {
        return cartService.createCart(cartDto);
    }

    @GetMapping("/cart/{cartId}/details")
    public ApiResponseDto<CartInfoDto> getCartDetails(@PathVariable String cartId) {
        return cartService.getCartDetails(cartId);
    }

    @GetMapping("/cart/{cartId}")
    public Cart getCart(@PathVariable String cartId) {
        return cartService.getCart(cartId);
    }
}
