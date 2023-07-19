package io.ngshop.catalog.repository.extension;


import io.ngshop.catalog.model.Product;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface ProductExtension {
    List<Product> findAllWithPagination(Optional<String> pageIndex, Optional<String> pageSize, Optional<String> brandId, Optional<String> typeId, Optional<String> sort, Optional<String> search);
    List<Product> findByBrandName(String brand);
}
