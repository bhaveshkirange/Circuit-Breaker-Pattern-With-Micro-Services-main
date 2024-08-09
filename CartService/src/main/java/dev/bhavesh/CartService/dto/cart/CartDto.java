/**
 * Copyright (C) 2023 Lokesh Bisht
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */

package dev.lokeshbisht.CartService.dto.cart;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.lokeshbisht.CartService.enums.CustomerType;
import lombok.Data;

import java.util.Date;
import java.util.List;

import static dev.lokeshbisht.CartService.constants.JsonConstants.ISO8601;

@Data
public class CartDto {

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("customer_type")
    private CustomerType customerType;

    private String operation;

    private List<ItemsDto> items;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO8601)
    @JsonProperty("created_at")
    private Date createdAt;
}
