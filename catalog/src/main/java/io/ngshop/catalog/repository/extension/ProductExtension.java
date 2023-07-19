package io.ngshop.catalog.repository.extension;


import io.ngshop.catalog.model.Product;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface ProductExtension {
    List<Product> findAllWithPagination(Optional<Integer> pageIndex, Optional<Integer> pageSize, Optional<ObjectId> brandId, Optional<ObjectId> typeId, Optional<String> sort, Optional<String> search);
}
