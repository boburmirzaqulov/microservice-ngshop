package io.ngshop.catalog.repository.ex;

import io.ngshop.catalog.dto.response.ProductResponse;
import io.ngshop.catalog.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryExtension {
    List<Product> getProductsByBrandName(String brandName);

    ProductResponse findAllWithPagination(Optional<String> pageIndex, Optional<String> pageSize, Optional<String> brandId, Optional<String> typeId, Optional<String> sort, Optional<String> search);
}
