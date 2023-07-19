package io.ngshop.catalog.service.impl;

import io.ngshop.catalog.dto.ProductDto;
import io.ngshop.catalog.mapper.ProductMapper;
import io.ngshop.catalog.model.Product;
import io.ngshop.catalog.repository.ProductRepository;
import io.ngshop.catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ResponseEntity<ProductDto> create(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        Product save = productRepository.save(product);
        return ResponseEntity.ok(productMapper.toDto(save));
    }

    public ResponseEntity<List<ProductDto>> getProducts() {
        List<Product> all = productRepository.findAll();
        List<ProductDto> list = all.stream().map(productMapper::toDto).toList();
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<ProductDto> getProductById(ObjectId id) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDto> createProduct(ProductDto productDTO) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDto> updateProduct(ProductDto productDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteProduct(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return null;
    }
}
