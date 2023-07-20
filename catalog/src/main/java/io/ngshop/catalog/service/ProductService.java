package io.ngshop.catalog.service;

import io.ngshop.catalog.dto.ProductDTO;
import io.ngshop.catalog.dto.response.ProductResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ResponseEntity<ProductDto> getProductById(String id);

    ResponseEntity<ProductDto> create(ProductDto productDTO);

    ResponseEntity<ProductDto> update(ProductDto productDTO, String productId);

    ResponseEntity<Void> delete(String id);
    ResponseEntity<ProductResponse> getByName(String productName);

    ResponseEntity<ProductResponse> getAllProducts(Optional<String> pageIndex, Optional<String> pageSize, Optional<String> brandId, Optional<String> typeId, Optional<String> sort, Optional<String> search);

    ResponseEntity<ProductResponse> getProductByBrandName(String brand);

}
