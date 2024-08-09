/**
 * Copyright (C) 2023 Lokesh Bisht
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */

package dev.lokeshbisht.CartService.mapper;

import dev.lokeshbisht.CartService.dto.cart.CartDto;
import dev.lokeshbisht.CartService.model.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {

    Cart toCart(CartDto cartDto);
    CartDto toCartDto(Cart cart);
}
