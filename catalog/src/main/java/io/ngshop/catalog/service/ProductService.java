package io.ngshop.catalog.service;

import io.ngshop.catalog.dto.ProductDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<ProductDto> create(ProductDto productDto);

    ResponseEntity<List<ProductDto>> getProducts();
}
