/**
 * Copyright (C) 2023 Lokesh Bisht
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */

package dev.lokeshbisht.CartService.controller;

import dev.lokeshbisht.CartService.dto.ErrorResponseDto;
import dev.lokeshbisht.CartService.enums.ErrorCode;
import dev.lokeshbisht.CartService.exceptions.CartNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleCartNotFoundException(CartNotFoundException ex) {
        log.error("CartNotFoundException: {}", ex.getMessage());
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorCode.CART_NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }
}
