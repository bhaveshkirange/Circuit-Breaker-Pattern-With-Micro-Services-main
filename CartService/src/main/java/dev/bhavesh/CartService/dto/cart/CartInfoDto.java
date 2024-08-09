/**
 * Copyright (C) 2023 Lokesh Bisht
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */

package dev.lokeshbisht.CartService.dto.cart;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.lokeshbisht.CartService.dto.catalog.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CartInfoDto {

    @JsonProperty("cart_id")
    private String cartId;

    private List<Product> items;
}
