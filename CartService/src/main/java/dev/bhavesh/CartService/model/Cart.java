/**
 * Copyright (C) 2023 Lokesh Bisht
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */

package dev.lokeshbisht.CartService.model;

import dev.lokeshbisht.CartService.dto.cart.ItemsDto;
import dev.lokeshbisht.CartService.enums.CustomerType;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Date;
import java.util.List;

@Data
@Builder
@RedisHash
public class Cart {

    @Id
    private String cartId;

    private String customerId;

    private CustomerType customerType;

    private String operation;

    private List<ItemsDto> items;

    private String createdBy;

    private Date createdAt;

    private String updatedBy;

    private Date updatedAt;
}
