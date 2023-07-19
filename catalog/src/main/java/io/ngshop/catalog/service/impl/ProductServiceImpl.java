package io.ngshop.catalog.service.impl;

import io.ngshop.catalog.dto.ProductDTO;
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
    public ResponseEntity<ProductDTO> getProductById(String id) {
        ObjectId objectId = CommonService.checkObjectId(id);
        Product product = productRepository.findById(objectId).orElseThrow(() -> new NotFoundException("Product not found"));
        return ResponseEntity.ok(productMapper.toDto(product));
    }

    @Override
    public ResponseEntity<List<ProductDTO>> getByName(String productName) {
        List<Product> products = productRepository.findByName(productName);
        return ResponseEntity.ok(products.stream().map(productMapper::toDto).toList());
    }

    @Override
    public ResponseEntity<List<ProductDTO>> getAllProducts(Optional<Integer> pageIndex, Optional<Integer> pageSize, Optional<ObjectId> brandId, Optional<ObjectId> typeId, Optional<String> sort, Optional<String> search) {
        List<Product> products = productRepository.findAllWithPagination(pageIndex,pageSize,brandId,typeId,sort,search);
        return ResponseEntity.ok(products.stream().map(productMapper::toDto).toList());
    }

    @Override
    public ResponseEntity<List<ProductDTO>> getProductByBrandName(String brand) {
        List<Product> products = productRepository.findByBrandName(brand);
        return ResponseEntity.ok(products.stream().map(productMapper::toDto).toList());
    }

    @Override
    public ResponseEntity<ProductDTO> create(ProductDTO productDto) {
        Product product = productMapper.toEntity(productDto);
        Product save = productRepository.save(product);
        return ResponseEntity.ok(productMapper.toDto(save));
    }

    @Override
    public ResponseEntity<ProductDTO> update(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDTO> delete(String id) {
        Product product = productRepository.findById(new ObjectId(id)).orElseThrow(() -> new NotFoundException("Product not found"));
        productRepository.delete(product);
        return ResponseEntity.ok(productMapper.toDto(product));
    }
}
