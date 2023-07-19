package io.ngshop.catalog.service;

import io.ngshop.catalog.dto.ProductDTO;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ResponseEntity<ProductDTO> getProductById(String id);

    ResponseEntity<ProductDTO> create(ProductDTO productDTO);

    ResponseEntity<ProductDTO> update(ProductDTO productDTO,String productId);

    ResponseEntity<ProductDTO> delete(String id);
    ResponseEntity<List<ProductDTO>> getByName(String productName);

    ResponseEntity<List<ProductDTO>> getAllProducts(Optional<Integer> pageIndex, Optional<Integer> pageSize, Optional<ObjectId> brandId, Optional<ObjectId> typeId, Optional<String> sort, Optional<String> search);

    ResponseEntity<List<ProductDTO>> getProductByBrandName(String brand);
}
