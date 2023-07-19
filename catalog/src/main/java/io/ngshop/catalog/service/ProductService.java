package io.ngshop.catalog.service;

import io.ngshop.catalog.dto.ProductDto;
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

    ResponseEntity<List<ProductDto>> getAllProducts(Optional<Integer> pageIndex, Optional<Integer> pageSize, Optional<ObjectId> brandId, Optional<ObjectId> typeId, Optional<String> sort, Optional<String> search);

    ResponseEntity<List<ProductDto>> getProductByBrandName(String brand);
}
