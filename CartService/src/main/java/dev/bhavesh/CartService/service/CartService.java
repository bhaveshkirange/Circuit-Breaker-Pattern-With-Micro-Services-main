/**
 * Copyright (C) 2023 Lokesh Bisht
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */

package dev.lokeshbisht.CartService.service;

import dev.lokeshbisht.CartService.dto.ApiResponseDto;
import dev.lokeshbisht.CartService.dto.cart.CartDto;
import dev.lokeshbisht.CartService.dto.cart.CartInfoDto;
import dev.lokeshbisht.CartService.model.Cart;

public interface CartService {

    Cart createCart(CartDto cartDto);
    ApiResponseDto<CartInfoDto> getCartDetails(String cartId);
    Cart getCart(String cartId);
}
