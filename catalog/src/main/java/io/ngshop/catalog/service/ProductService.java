package io.ngshop.catalog.service;

import io.ngshop.catalog.dto.ProductDto;
import io.ngshop.catalog.dto.ProductResponse;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ResponseEntity<ProductDto> getProductById(String id);

    ResponseEntity<ProductDto> create(ProductDto productDTO);

    ResponseEntity<ProductDto> update(ProductDto productDTO, String productId);

    ResponseEntity<ProductDto> delete(String id);
    ResponseEntity<List<ProductDto>> getByName(String productName);

    ResponseEntity<ProductResponse> getAllProducts(Integer pageIndex, Integer pageSize, Optional<String> brandId, Optional<String> typeId, Optional<String> sort, Optional<String> search);

    ResponseEntity<List<ProductDto>> getProductByBrandName(String brand);
}
