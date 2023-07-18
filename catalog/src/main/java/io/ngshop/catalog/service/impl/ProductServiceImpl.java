package io.ngshop.catalog.service.impl;

import io.ngshop.catalog.dto.ProductDTO;
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
    @Override
    public ResponseEntity<ProductDTO> getProductById(ObjectId id) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDTO> createProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);

        ProductDTO productDTO1 = productMapper.toDto(productRepository.save(product));
        return ResponseEntity.ok(productDTO1);
    }

    @Override
    public ResponseEntity<ProductDTO> updateProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteProduct(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return null;
    }
}
