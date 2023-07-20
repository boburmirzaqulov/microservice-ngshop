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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ResponseEntity<ProductDTO> createProduct(ProductDTO productDto) {
        Product product = productMapper.toEntity(productDto);
        Product save = productRepository.save(product);
        return ResponseEntity.ok(productMapper.toDto(save));
    }

    @Override
    public ResponseEntity<ProductDTO> getProductById(ObjectId id) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<Product> all = productRepository.findAll();
        List<ProductDTO> list = all.stream().map(productMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<ProductDTO> updateProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteProduct(Long id) {
        return null;
    }
}
