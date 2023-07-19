package io.ngshop.catalog.service;

import io.ngshop.catalog.dto.ProductDto;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {


    ResponseEntity<ProductDto> getProductById(ObjectId id);

    ResponseEntity<ProductDto> createProduct(ProductDto productDTO);

    ResponseEntity<ProductDto> updateProduct(ProductDto productDTO);

    ResponseEntity<Void> deleteProduct(Long id);

    ResponseEntity<List<ProductDto>> getAllProducts();
}
