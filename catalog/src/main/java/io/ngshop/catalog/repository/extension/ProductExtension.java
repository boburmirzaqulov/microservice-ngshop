package io.ngshop.catalog.repository.extension;


import io.ngshop.catalog.dto.ProductResponse;
import io.ngshop.catalog.model.Product;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductExtension {
    ResponseEntity<ProductResponse> findAllWithPagination(Integer pageIndex, Integer pageSize, Optional<String> brandId, Optional<String> typeId, Optional<String> sort, Optional<String> search);
    List<Product> findByBrandName(String brand);

}
