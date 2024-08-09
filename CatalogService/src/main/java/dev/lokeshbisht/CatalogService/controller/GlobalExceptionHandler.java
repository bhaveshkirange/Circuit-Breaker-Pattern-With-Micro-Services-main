/**
 * Copyright (C) 2023 Lokesh Bisht
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */

package dev.lokeshbisht.CatalogService.controller;

import dev.lokeshbisht.CatalogService.constants.ErrorCode;
import dev.lokeshbisht.CatalogService.dto.ErrorResponseDto;
import dev.lokeshbisht.CatalogService.exceptions.InvalidResourceException;
import dev.lokeshbisht.CatalogService.exceptions.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleProductNotFoundException(Exception ex) {
        log.error("ProductNotFoundException: {}", ex.getMessage());
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorCode.PRODUCT_NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidResourceException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidResourceException(InvalidResourceException ex) {
        log.error("InvalidResourceException: {}", ex.getMessage());
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorCode.INVALID_RESOURCE, ex.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleAllExceptions(Exception ex) {
        UUID uuid = UUID.randomUUID();
        String message = String.format("Unhandled exception, logged against error id: %s", uuid);
        log.error("Exception: {} {}", message, ex.getClass().getName(), ex);
        log.error(ex.getMessage(), ex);
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorCode.INTERNAL_SERVER_ERROR, message);
        return new ResponseEntity<>(errorResponseDto, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
