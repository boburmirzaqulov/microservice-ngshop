package io.ngshop.catalog.mapper;

import io.ngshop.catalog.dto.ProductDto;
import io.ngshop.catalog.model.Product;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
@Service
public class ProductMapper {
    public ProductDto toDto(Product product){
        return product == null ? null : new ProductDto(
                product.getId().toString(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getSummary(),
                product.getImageFile(),
                product.getBrandId(),
                product.getTypeId()
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
                productDto.getBrandId(),
                productDto.getTypeId()
        );
    }
}