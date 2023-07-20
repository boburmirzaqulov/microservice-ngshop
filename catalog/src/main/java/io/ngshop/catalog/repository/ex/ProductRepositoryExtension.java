package io.ngshop.catalog.repository.ex;

import io.ngshop.catalog.model.Product;

import java.util.List;

public interface ProductRepositoryExtension {
    List<Product> getProductsByBrandName(String brandName);
}
