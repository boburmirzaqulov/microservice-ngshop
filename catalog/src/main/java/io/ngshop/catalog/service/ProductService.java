package io.ngshop.catalog.service;

import io.ngshop.catalog.dto.ProductDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {


    ResponseEntity<ProductDTO> getProductById(Long id);

    ResponseEntity<ProductDTO> createProduct(ProductDTO productDTO);

    ResponseEntity<ProductDTO> updateProduct(ProductDTO productDTO);

    ResponseEntity<Void> deleteProduct(Long id);

    ResponseEntity<List<ProductDTO>> getAllProducts();
}
