package io.ngshop.catalog.service.impl;

import io.ngshop.catalog.dto.ProductDTO;
import io.ngshop.catalog.dto.response.ProductResponse;
import io.ngshop.catalog.exception.NotFoundException;
import io.ngshop.catalog.mapper.ProductMapper;
import io.ngshop.catalog.model.Product;
import io.ngshop.catalog.repository.ProductRepository;
import io.ngshop.catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ResponseEntity<ProductResponse> getByName(String productName) {
        List<Product> products = productRepository.findByName(productName);
        return ResponseEntity.ok(ProductResponse.builder().data(products.stream().map(productMapper::toDto).toList()).count(products.size()).build());
    }

    @Override
    public ResponseEntity<ProductResponse> getAllProducts(Optional<String> pageIndex, Optional<String> pageSize, Optional<String> brandId, Optional<String> typeId, Optional<String> sort, Optional<String> search) {
        ProductResponse withPagination = productRepository.findAllWithPagination(pageIndex, pageSize, brandId, typeId, sort, search);
        return ResponseEntity.ok(withPagination);
    }

    @Override
    public ResponseEntity<ProductResponse> getProductByBrandName(String brand) {
        List<Product> products = productRepository.findByBrandName(brand);
        return ResponseEntity.ok(ProductResponse.builder().data(products.stream().map(productMapper::toDto).toList()).count(products.size()).build());
    }

    @Override
    public ResponseEntity<ProductDTO> getProductById(String id) {
        Product product = productRepository.findById(CommonService.checkObjectId(id)).orElseThrow(() -> new NotFoundException("Product not found"));
        return ResponseEntity.ok(productMapper.toDto(product));
    }

    @Override
    public ResponseEntity<ProductDTO> create(ProductDTO ProductDTO) {
        ProductDTO.setName(ProductDTO.getName().toLowerCase());
        Product product = productMapper.toEntity(ProductDTO);
        Product save = productRepository.save(product);
        return ResponseEntity.ok(productMapper.toDto(save));
    }

    @Override
    public ResponseEntity<ProductDTO> update(ProductDTO ProductDTO, String productId) {
        ProductDTO.setName(ProductDTO.getName().toLowerCase());
        productRepository.findById(CommonService.checkObjectId(productId)).orElseThrow(() -> new NotFoundException("Product not found"));
        Product entity = productMapper.toEntity(ProductDTO);
        Product save = productRepository.save(entity);
        return ResponseEntity.ok(productMapper.toDto(save));
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        Product product = productRepository.findById(CommonService.checkObjectId(id)).orElseThrow(() -> new NotFoundException("Product not found"));
        productRepository.delete(product);
        return ResponseEntity.ok().build();
    }

}
