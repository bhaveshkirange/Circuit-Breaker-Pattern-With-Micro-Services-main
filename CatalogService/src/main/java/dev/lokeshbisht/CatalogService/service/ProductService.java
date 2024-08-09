/**
 * Copyright (C) 2023 Lokesh Bisht
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */

package dev.lokeshbisht.CatalogService.service;

import dev.lokeshbisht.CatalogService.dto.ApiResponseDto;
import dev.lokeshbisht.CatalogService.dto.ProductDto;
import dev.lokeshbisht.CatalogService.entity.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(ProductDto productDto);
    ApiResponseDto<Product> getProductByProductId(Long productId);
    ApiResponseDto<Product> getProductByProductCode(String productCode);
    ApiResponseDto<List<ProductDto>>getProducts(List<String> productCodeList);
}
