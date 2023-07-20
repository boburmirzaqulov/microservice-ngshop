package io.ngshop.catalog.mapper;

import io.ngshop.catalog.dto.ProductDTO;
import io.ngshop.catalog.exception.NotFoundException;
import io.ngshop.catalog.model.Product;
import io.ngshop.catalog.repository.BrandRepository;
import io.ngshop.catalog.repository.TypeRepository;
import io.ngshop.catalog.service.impl.CommonService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductMapper {
    private final BrandRepository brandRepository;
    private final TypeRepository typeRepository;


    public ProductDTO toDto(Product product){
        return product == null ? null : new ProductDTO(
                product.getId() != null ? product.getId().toString() : null,
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getSummary(),
                product.getImageFile(),
                brandRepository.findById(product.getBrandId()).orElseThrow(() -> new NotFoundException("Brand not found")).getName(),
                typeRepository.findById(product.getTypeId()).orElseThrow(() -> new NotFoundException("Type not found")).getName()
        );
    }
    public Product toEntity(ProductDto productDto){
        return productDto == null ? null : new Product(
                null,

                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getSummary(),
                productDto.getImageFile(),
                CommonService.checkObjectId(productDto.getBrandId()),
                CommonService.checkObjectId(productDto.getTypeId())

        );
    }
}