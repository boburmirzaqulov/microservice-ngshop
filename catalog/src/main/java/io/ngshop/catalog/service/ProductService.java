package io.ngshop.catalog.service;

import io.ngshop.catalog.dto.ProductDTO;
import io.ngshop.catalog.dto.response.ProductResponse;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ProductService {

    ResponseEntity<ProductDTO> getProductById(String id);
    ResponseEntity<ProductDTO> create(ProductDTO productDTO);
    ResponseEntity<ProductDTO> update(ProductDTO productDTO, String productId);
    ResponseEntity<Void> delete(String id);
    ResponseEntity<ProductResponse> getByName(String productName);
    ResponseEntity<ProductResponse> getAllProducts(Optional<String> pageIndex, Optional<String> pageSize, Optional<String> brandId, Optional<String> typeId, Optional<String> sort, Optional<String> search);
    ResponseEntity<ProductResponse> getProductByBrandName(String brand);
}
