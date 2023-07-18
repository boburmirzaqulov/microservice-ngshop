package io.ngshop.catalog.service;

import io.ngshop.catalog.dto.BrandDto;
import io.ngshop.catalog.dto.ProductDto;
import io.ngshop.catalog.dto.TypeDto;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CatalogService {
    ResponseEntity<ProductDto> getProductById(ObjectId id);

    ResponseEntity<List<ProductDto>> getProductByProductName(String productName);

    ResponseEntity<List<ProductDto>> getAllProducts();

    ResponseEntity<List<BrandDto>> getAllBrands();

    ResponseEntity<List<TypeDto>> getAllTypes();

    ResponseEntity<List<ProductDto>> getProductsByBrandName(String brand);

    ResponseEntity<ProductDto> createProduct(ProductDto productDto);

    boolean updateProduct(ProductDto productDto);

    boolean deleteProduct(ObjectId objectId);
}
