package io.ngshop.catalog.service.Impl;

import io.ngshop.catalog.dto.ProductDto;
import io.ngshop.catalog.mapper.ProductMapper;
import io.ngshop.catalog.model.Product;
import io.ngshop.catalog.repository.ProductRepository;
import io.ngshop.catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ResponseEntity<ProductDto> create(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        Product save = productRepository.save(product);
        return ResponseEntity.ok(productMapper.toDto(save));
    }

    @Override
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<Product> all = productRepository.findAll();
        List<ProductDto> list = all.stream().map(productMapper::toDto).toList();
        return ResponseEntity.ok(list);
    }
}
