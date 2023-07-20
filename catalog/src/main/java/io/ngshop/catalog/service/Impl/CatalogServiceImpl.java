package io.ngshop.catalog.service.impl;

import io.ngshop.catalog.dto.BrandDto;
import io.ngshop.catalog.dto.ProductDto;
import io.ngshop.catalog.dto.TypeDto;
import io.ngshop.catalog.mapper.BrandMapper;
import io.ngshop.catalog.mapper.ProductMapper;
import io.ngshop.catalog.mapper.TypeMapper;
import io.ngshop.catalog.model.Brand;
import io.ngshop.catalog.model.Product;
import io.ngshop.catalog.model.Type;
import io.ngshop.catalog.repository.BrandRepository;
import io.ngshop.catalog.repository.ProductRepository;
import io.ngshop.catalog.repository.TypeRepository;
import io.ngshop.catalog.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;
    private final TypeRepository typeRepository;
    private final TypeMapper typeMapper;

    @Override
    public ResponseEntity<ProductDto> getProductById(ObjectId id) {
        Product product = productRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(productMapper.toDto(product));
    }

    @Override
    public ResponseEntity<List<ProductDto>> getProductByProductName(String productName) {
        List<Product> products = productRepository.findByName(productName);
        return ResponseEntity.ok(products.stream().map(productMapper::toDto).toList());
    }

    @Override
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<Product> all = productRepository.findAll();
        System.out.println(all);
        return ResponseEntity.ok(all.stream().map(productMapper::toDto).toList());
    }

    @Override
    public ResponseEntity<List<BrandDto>> getAllBrands() {
        List<Brand> brands = brandRepository.findAll();
        return ResponseEntity.ok(brands.stream().map(brandMapper::toDto).toList());
    }

    @Override
    public ResponseEntity<List<TypeDto>> getAllTypes() {
        List<Type> types = typeRepository.findAll();
        return ResponseEntity.ok(types.stream().map(typeMapper::toDto).toList());
    }

    @Override
    public ResponseEntity<List<ProductDto>> getProductsByBrandName(String brand) {
        return ResponseEntity.ok(productRepository.getProductsByBrandName(brand).stream().map(productMapper::toDto).toList());
    }

    @Override
    public ResponseEntity<ProductDto> createProduct(ProductDto productDto) {
        Product product = productRepository.save(productMapper.toEntity(productDto));
        return ResponseEntity.ok(productMapper.toDto(product));
    }

    @Override
    public boolean updateProduct(ProductDto productDto) {
        if (productDto == null){
            return false;
        }
        Product product = new Product();
        if (productDto.getBrandId() != null){product.setBrandId(product.getBrandId());}
        if (productDto.getSummary() != null){product.setSummary(product.getSummary());}
        if (productDto.getDescription() != null){product.setDescription(product.getDescription());}
        if (productDto.getName() != null){product.setName(product.getName());}
        if (productDto.getPrice() != null){product.setPrice(product.getPrice());}
        if (productDto.getImageFile() != null){product.setImageFile(product.getImageFile());}
        if (productDto.getTypeId() != null){product.setTypeId(product.getTypeId());}
        productRepository.save(product);
        return true;
    }

    @Override
    public boolean deleteProduct(ObjectId objectId) {
        if (productRepository.findById(objectId).isEmpty()){
            return false;
        }
        productRepository.deleteById(objectId);
        return true;
    }

}
