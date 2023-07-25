package io.ngshop.catalog.service.imp;

import io.ngshop.catalog.dto.ProductDto;
import io.ngshop.catalog.dto.ProductResponse;
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
    public ResponseEntity<ProductDto> getProductById(String id) {
        ObjectId objectId = CommonService.checkObjectId(id);
        Product product = productRepository.findById(objectId).orElseThrow(() -> new NotFoundException("Product not found"));
        return ResponseEntity.ok(productMapper.toDto(product));
    }

    @Override
    public ResponseEntity<ProductDto> update(ProductDto productDTO, String productId) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDto> delete(String id) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductDto>> getByName(String productName) {
        return null;
    }

    @Override
    public ResponseEntity<ProductResponse> getAllProducts(Integer pageIndex, Integer pageSize, Optional<String> brandId, Optional<String> typeId, Optional<String> sort, Optional<String> search) {
        return productRepository.findAllWithPagination(pageIndex,pageSize,brandId,typeId,sort,search);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getProductByBrandName(String brand) {
        return null;
    }
}
